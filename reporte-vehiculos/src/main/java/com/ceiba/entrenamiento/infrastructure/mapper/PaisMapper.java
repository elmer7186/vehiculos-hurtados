package com.ceiba.entrenamiento.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.ceiba.entrenamiento.domain.entity.Pais;
import com.ceiba.entrenamiento.infrastructure.entity.PaisEntity;

@Component
public class PaisMapper {

	public Pais mapToDomain(PaisEntity paisEntity) {
		return new Pais(paisEntity.getId(), paisEntity.getCodigo(), paisEntity.getNombre());
	}

	public PaisEntity mapToEntity(Pais pais) {
		return new PaisEntity(pais.getId(), pais.getCodigo(), pais.getNombre());
	}

}
