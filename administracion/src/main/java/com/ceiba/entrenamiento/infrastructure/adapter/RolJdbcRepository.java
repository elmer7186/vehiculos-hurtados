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

import com.ceiba.entrenamiento.domain.entity.Rol;
import com.ceiba.entrenamiento.domain.port.RolRepository;
import com.ceiba.entrenamiento.infrastructure.mapper.RolMapper;

@Repository
public class RolJdbcRepository implements RolRepository {

	private static final String SQL_GUARDAR_ROL_USUARIO = "INSERT INTO rol (nombre, descripcion) VALUES (:nombre, :descripcion)";
	private static final String SQL_FIND_BY_NOMBRE = "SELECT id, nombre, descripcion FROM rol WHERE nombre = :nombre";

	private NamedParameterJdbcTemplate namedJdbcTemplate;
	private RolMapper rolMapper;

	@Autowired
	public RolJdbcRepository(NamedParameterJdbcTemplate namedJdbcTemplate, RolMapper rolMapper) {
		this.namedJdbcTemplate = namedJdbcTemplate;
		this.rolMapper = rolMapper;
	}

	@Override
	public Rol save(Rol rol) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new MapSqlParameterSource(rolMapper.mapToMap(rol));
		namedJdbcTemplate.update(SQL_GUARDAR_ROL_USUARIO, parameterSource, keyHolder);
		rol.setId((long) keyHolder.getKey());
		return rol;
	}

	@Override
	public Rol findByNombre(String nombre) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(RolMapper.NOMBRE, nombre);
		Map<String, Object> resultSet = namedJdbcTemplate.queryForMap(SQL_FIND_BY_NOMBRE, paramMap);
		return rolMapper.mapToDomain(resultSet);
	}

}
