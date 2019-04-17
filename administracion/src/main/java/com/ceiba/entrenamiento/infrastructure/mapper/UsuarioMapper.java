package com.ceiba.entrenamiento.infrastructure.mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ceiba.entrenamiento.domain.entity.Usuario;

@Component
public class UsuarioMapper {

	public static final String ID = "id";
	public static final String NOMBRE = "nombre";
	public static final String CLAVE = "clave";
	public static final String EMAIL = "email";
	public static final String HABILITADO = "habilitado";
	public static final String VENCIMIENTO = "vencimiento";

	public Usuario mapToDomain(Map<String, Object> resultSet) {
		return new Usuario((Long) resultSet.get(ID), (String) resultSet.get(NOMBRE), (String) resultSet.get(CLAVE),
				(String) resultSet.get(EMAIL), (Boolean) resultSet.get(HABILITADO), (Date) resultSet.get(VENCIMIENTO));
	}

	public Map<String, Object> mapToMap(Usuario usuario) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(ID, usuario.getId());
		paramMap.put(NOMBRE, usuario.getNombre());
		paramMap.put(CLAVE, usuario.getClave());
		paramMap.put(EMAIL, usuario.getEmail());
		paramMap.put(HABILITADO, usuario.isHabilitado());
		paramMap.put(VENCIMIENTO, usuario.getVencimiento());
		return paramMap;
	}

}
