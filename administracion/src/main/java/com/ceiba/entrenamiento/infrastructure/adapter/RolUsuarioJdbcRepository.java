package com.ceiba.entrenamiento.infrastructure.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ceiba.entrenamiento.domain.entity.RolUsuario;
import com.ceiba.entrenamiento.domain.entity.Usuario;
import com.ceiba.entrenamiento.domain.port.RolUsuarioRepository;
import com.ceiba.entrenamiento.infrastructure.mapper.RolUsuarioMapper;

@Repository
public class RolUsuarioJdbcRepository implements RolUsuarioRepository {

	private static final String SQL_INSERTAR_ROL_USUARIO = "INSERT INTO rolusuario (usuario, rol) VALUES (:usuario, :rol)";
	private static final String SQL_FIND_BY_USUARIO = "SELECT rolusu.id, rolusu.usuario, rolusu.rol, rol.nombre, rol.descripcion FROM rolusuario rolusu INNER JOIN rol rol ON rolusu.rol = rol.id WHERE usuario = :usuario";

	private NamedParameterJdbcTemplate namedJdbcTemplate;
	private RolUsuarioMapper rolUsuarioMapper;

	public RolUsuarioJdbcRepository(NamedParameterJdbcTemplate namedJdbcTemplate, RolUsuarioMapper rolUsuarioMapper) {
		this.namedJdbcTemplate = namedJdbcTemplate;
		this.rolUsuarioMapper = rolUsuarioMapper;
	}

	@Override
	public RolUsuario save(RolUsuario rolUsuario) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new MapSqlParameterSource(rolUsuarioMapper.mapToMap(rolUsuario));
		namedJdbcTemplate.update(SQL_INSERTAR_ROL_USUARIO, parameterSource, keyHolder);
		rolUsuario.setId((long) keyHolder.getKey());
		return rolUsuario;
	}

	@Override
	public List<RolUsuario> findByUsuario(Usuario usuario) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(RolUsuarioMapper.USUARIO, usuario.getId());
		List<Map<String, Object>> resultList = namedJdbcTemplate.queryForList(SQL_FIND_BY_USUARIO, paramMap);
		return rolUsuarioMapper.mapToDomain(resultList, usuario);
	}

}
