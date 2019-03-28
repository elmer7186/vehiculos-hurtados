package com.ceiba.entrenamiento.domain.port;

import com.ceiba.entrenamiento.domain.entity.Pais;

public interface PaisRepository {

	void save(Pais pais);

	Pais findByCodigo(String codigo);

}
