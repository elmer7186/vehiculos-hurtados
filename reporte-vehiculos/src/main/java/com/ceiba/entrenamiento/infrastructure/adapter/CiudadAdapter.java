package com.ceiba.entrenamiento.infrastructure.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.entrenamiento.domain.entity.Ciudad;
import com.ceiba.entrenamiento.domain.port.CiudadRepository;
import com.ceiba.entrenamiento.infrastructure.mapper.CiudadMapper;
import com.ceiba.entrenamiento.infrastructure.repository.CiudadRepositoryData;

@Repository
public class CiudadAdapter implements CiudadRepository {

	private CiudadRepositoryData ciudadRepositoryData;
	private CiudadMapper ciudadMapper;

	@Autowired
	public CiudadAdapter(CiudadRepositoryData ciudadRepositoryData, CiudadMapper ciudadMapper) {
		this.ciudadRepositoryData = ciudadRepositoryData;
		this.ciudadMapper = ciudadMapper;
	}

	@Override
	public void save(Ciudad ciudad) {
		ciudadRepositoryData.save(ciudadMapper.mapToEntity(ciudad));

	}

	@Override
	public Ciudad findByCodigo(String codigo) {
		return ciudadMapper.mapToDomain(ciudadRepositoryData.findByCodigo(codigo));
	}

}
