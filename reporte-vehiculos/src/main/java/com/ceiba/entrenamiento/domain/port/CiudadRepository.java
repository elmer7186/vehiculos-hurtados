package com.ceiba.entrenamiento.domain.port;

import com.ceiba.entrenamiento.domain.entity.Ciudad;

public interface CiudadRepository {

	void save(Ciudad ciudad);

	Ciudad findByCodigo(String codigo);

}
