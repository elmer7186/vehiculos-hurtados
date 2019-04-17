package com.ceiba.entrenamiento.domain.port;

import java.util.List;

import com.ceiba.entrenamiento.domain.entity.RolUsuario;
import com.ceiba.entrenamiento.domain.entity.Usuario;

public interface RolUsuarioRepository {

	RolUsuario save(RolUsuario rolUsuario);

	List<RolUsuario> findByUsuario(Usuario usuario);

}
