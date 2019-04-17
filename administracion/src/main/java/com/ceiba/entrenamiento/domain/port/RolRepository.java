package com.ceiba.entrenamiento.domain.port;

import com.ceiba.entrenamiento.domain.entity.Rol;

public interface RolRepository {

	Rol save(Rol rol);

	Rol findByNombre(String nombre);

}
