package com.ceiba.entrenamiento.infrastructure.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ceiba.entrenamiento.domain.entity.Rol;
import com.ceiba.entrenamiento.domain.entity.RolUsuario;
import com.ceiba.entrenamiento.domain.entity.Usuario;

@Component
public class RolUsuarioMapper {

	public static final String ID = "id";
	public static final String USUARIO = "usuario";
	public static final String ROL = "rol";

	public Map<String, Object> mapToMap(RolUsuario rolUsuario) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(ID, rolUsuario.getId());
		paramMap.put(USUARIO, rolUsuario.getUsuario().getId());
		paramMap.put(ROL, rolUsuario.getRol().getId());
		return paramMap;
	}

	public RolUsuario mapToDomain(Map<String, Object> resultSet, Usuario usuario) {
		Rol rol = new Rol((Long) resultSet.get(ROL), (String) resultSet.get(RolMapper.NOMBRE),
				(String) resultSet.get(RolMapper.DESCRIPCION));
		return new RolUsuario((Long) resultSet.get(ID), usuario, rol);
	}

	public List<RolUsuario> mapToDomain(List<Map<String, Object>> resultList, Usuario usuario) {
		List<RolUsuario> rolesUsuarioRetorno = new ArrayList<>();
		resultList.forEach(resultSet -> rolesUsuarioRetorno.add(mapToDomain(resultSet, usuario)));
		return rolesUsuarioRetorno;
	}

}
