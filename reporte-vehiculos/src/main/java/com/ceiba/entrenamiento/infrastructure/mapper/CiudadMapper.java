package com.ceiba.entrenamiento.infrastructure.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.entrenamiento.domain.entity.Ciudad;
import com.ceiba.entrenamiento.infrastructure.entity.CiudadEntity;

@Component
public class CiudadMapper {

	@Autowired
	private PaisMapper paisMapper;

	public Ciudad mapToDomain(CiudadEntity ciudadEntity) {
		Ciudad ciudadRetorno = null;
		if (ciudadEntity != null) {
			ciudadRetorno = new Ciudad(ciudadEntity.getId(), paisMapper.mapToDomain(ciudadEntity.getPais()),
					ciudadEntity.getCodigo(), ciudadEntity.getNombre());
		}
		return ciudadRetorno;
	}

	public CiudadEntity mapToEntity(Ciudad ciudad) {
		CiudadEntity ciudadRetorno = null;
		if (ciudad != null) {
			ciudadRetorno = new CiudadEntity(ciudad.getId(), paisMapper.mapToEntity(ciudad.getPais()),
					ciudad.getCodigo(), ciudad.getNombre());
		}
		return ciudadRetorno;
	}

}
