package com.ceiba.entrenamiento.infrastructure.adapter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.entrenamiento.domain.entity.Hurto;
import com.ceiba.entrenamiento.domain.port.HurtoRepository;
import com.ceiba.entrenamiento.infrastructure.entity.HurtoEntity;
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
	public Hurto save(Hurto hurto) {
		HurtoEntity hurtoEntity = hurtoRepositoryData.save(hurtoMapper.mapToEntity(hurto));
		return hurtoMapper.mapToDomain(hurtoEntity);
	}

	@Override
	public Hurto findById(String idHurto) {
		Hurto hurtoRetorno = null;
		Optional<HurtoEntity> opcional = hurtoRepositoryData.findById(idHurto);
		if (opcional.isPresent()) {
			hurtoRetorno = hurtoMapper.mapToDomain(opcional.get());
		}
		return hurtoRetorno;
	}

}
