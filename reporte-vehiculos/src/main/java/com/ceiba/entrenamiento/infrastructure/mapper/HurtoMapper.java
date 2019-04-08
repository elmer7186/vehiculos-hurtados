package com.ceiba.entrenamiento.infrastructure.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.entrenamiento.domain.entity.Hurto;
import com.ceiba.entrenamiento.infrastructure.entity.HurtoEntity;

@Component
public class HurtoMapper {

	@Autowired
	private CiudadMapper ciudadMapper;

	@Autowired
	private VehiculoMapper vehiculoMapper;

	public HurtoEntity mapToEntity(Hurto hurto) {
		return new HurtoEntity(hurto.getId(), vehiculoMapper.mapToEntity(hurto.getVehiculo()),
				ciudadMapper.mapToEntity(hurto.getCiudad()), hurto.getFechaHurto(), hurto.getDescripcion());
	}

	public Hurto mapToDomain(HurtoEntity hurtoEntity) {
		return new Hurto(hurtoEntity.getId(), vehiculoMapper.mapToDomain(hurtoEntity.getVehiculo()),
				ciudadMapper.mapToDomain(hurtoEntity.getCiudad()), hurtoEntity.getFechaHurto(),
				hurtoEntity.getDescripcion());
	}

}
