package com.ceiba.entrenamiento.domain.port;

import com.ceiba.entrenamiento.domain.entity.Usuario;

public interface UsuarioRepository {

	Usuario save(Usuario usuario);

	Usuario findByNombre(String nombre);

}
