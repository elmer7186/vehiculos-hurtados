package com.ceiba.entrenamiento.infrastructure.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.entrenamiento.domain.entity.Hurto;
import com.ceiba.entrenamiento.domain.port.HurtoRepository;
import com.ceiba.entrenamiento.infrastructure.mapper.HurtoMapper;
import com.ceiba.entrenamiento.infrastructure.repository.HurtoRepositoryData;

@Repository
public class HurtoAdapter implements HurtoRepository {

	private HurtoRepositoryData hurtoRepositoryData;
	private HurtoMapper hurtoMapper;

	@Autowired
	public HurtoAdapter(HurtoRepositoryData hurtoRepositoryData, HurtoMapper hurtoMapper) {
		this.hurtoRepositoryData = hurtoRepositoryData;
		this.hurtoMapper = hurtoMapper;
	}

	@Override
	public void save(Hurto hurto) {
		hurtoRepositoryData.save(hurtoMapper.mapToEntity(hurto));
	}

}
