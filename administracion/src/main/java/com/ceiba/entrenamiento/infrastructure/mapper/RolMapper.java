package com.ceiba.entrenamiento.infrastructure.mapper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ceiba.entrenamiento.domain.entity.Rol;

@Component
public class RolMapper {

	public static final String ID = "id";
	public static final String NOMBRE = "nombre";
	public static final String DESCRIPCION = "descripcion";

	public Rol mapToDomain(Map<String, Object> resultSet) {
		return new Rol((Long) resultSet.get(ID), (String) resultSet.get(NOMBRE), (String) resultSet.get(DESCRIPCION));
	}

	public Map<String, Object> mapToMap(Rol rol) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(ID, rol.getId());
		paramMap.put(NOMBRE, rol.getNombre());
		paramMap.put(DESCRIPCION, rol.getDescripcion());
		return paramMap;
	}

}
