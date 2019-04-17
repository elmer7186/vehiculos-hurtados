package com.ceiba.entrenamiento.infrastructure.adapter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ceiba.entrenamiento.domain.entity.Usuario;
import com.ceiba.entrenamiento.domain.port.UsuarioRepository;
import com.ceiba.entrenamiento.infrastructure.mapper.UsuarioMapper;

@Repository
public class UsuarioJdbcRepository implements UsuarioRepository {

	private static final String SQL_CREAR_USUARIO = "INSERT INTO usuario (nombre, clave, email, habilitado, vencimiento) VALUES (:nombre, :clave, :email, :habilitado, :vencimiento)";
	private static final String SQL_GET_USUARIO_BY_NOMBRE = "SELECT id, nombre, clave, email, habilitado, vencimiento FROM usuario WHERE nombre = :nombre";

	private NamedParameterJdbcTemplate namedJdbcTemplate;
	private UsuarioMapper usuarioMapper;

	@Autowired
	public UsuarioJdbcRepository(NamedParameterJdbcTemplate namedJdbcTemplate, UsuarioMapper usuarioMapper) {
		this.namedJdbcTemplate = namedJdbcTemplate;
		this.usuarioMapper = usuarioMapper;
	}

	@Override
	public Usuario save(Usuario usuario) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new MapSqlParameterSource(usuarioMapper.mapToMap(usuario));
		namedJdbcTemplate.update(SQL_CREAR_USUARIO, parameterSource, keyHolder);
		usuario.setId((long) keyHolder.getKey());
		return usuario;
	}

	@Override
	public Usuario findByNombre(String nombre) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(UsuarioMapper.NOMBRE, nombre);
		Map<String, Object> resultSet = namedJdbcTemplate.queryForMap(SQL_GET_USUARIO_BY_NOMBRE, paramMap);
		return usuarioMapper.mapToDomain(resultSet);
	}

}
