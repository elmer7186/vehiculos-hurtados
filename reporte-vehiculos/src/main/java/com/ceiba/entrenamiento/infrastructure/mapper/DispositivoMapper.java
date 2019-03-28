package com.ceiba.entrenamiento.infrastructure.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.entrenamiento.domain.entity.Dispositivo;
import com.ceiba.entrenamiento.infrastructure.entity.DispositivoEntity;

@Component
public class DispositivoMapper {

	@Autowired
	private CiudadMapper ciudadMapper;

	public Dispositivo mapToDomain(DispositivoEntity dispositivoEntity) {
		return new Dispositivo(dispositivoEntity.getId(), ciudadMapper.mapToDomain(dispositivoEntity.getCiudad()),
				dispositivoEntity.getImei(), dispositivoEntity.getUbicacionGps(), dispositivoEntity.getDescripcion(),
				dispositivoEntity.isHabilitado());
	}

	public DispositivoEntity mapToEntity(Dispositivo dispositivo) {
		return new DispositivoEntity(dispositivo.getId(), ciudadMapper.mapToEntity(dispositivo.getCiudad()),
				dispositivo.getImei(), dispositivo.getUbicacionGps(), dispositivo.getDescripcion(),
				dispositivo.isHabilitado());
	}

}
