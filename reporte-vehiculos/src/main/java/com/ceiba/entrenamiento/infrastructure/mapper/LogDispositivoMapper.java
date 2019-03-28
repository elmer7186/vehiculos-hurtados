package com.ceiba.entrenamiento.infrastructure.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.entrenamiento.domain.entity.LogDispositivo;
import com.ceiba.entrenamiento.infrastructure.entity.LogDispositivoEntity;

@Component
public class LogDispositivoMapper {

	@Autowired
	private DispositivoMapper dispositivoMapper;

	public LogDispositivoEntity mapToEntity(LogDispositivo logDispositivo) {
		return new LogDispositivoEntity(logDispositivo.getId(),
				dispositivoMapper.mapToEntity(logDispositivo.getDispositivo()), logDispositivo.getEstado(),
				logDispositivo.getDetalle());
	}

}
