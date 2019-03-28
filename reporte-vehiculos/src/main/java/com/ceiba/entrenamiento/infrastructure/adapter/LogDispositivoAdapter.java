package com.ceiba.entrenamiento.infrastructure.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.entrenamiento.domain.entity.LogDispositivo;
import com.ceiba.entrenamiento.domain.port.LogDispositivoRepository;
import com.ceiba.entrenamiento.infrastructure.mapper.LogDispositivoMapper;
import com.ceiba.entrenamiento.infrastructure.repository.LogDispositivoRepositoryData;

@Repository
public class LogDispositivoAdapter implements LogDispositivoRepository {

	private LogDispositivoRepositoryData logDispositivoRepositoryData;
	private LogDispositivoMapper logDispositivoMapper;

	@Autowired
	public LogDispositivoAdapter(LogDispositivoRepositoryData logDispositivoRepositoryData,
			LogDispositivoMapper logDispositivoMapper) {
		this.logDispositivoRepositoryData = logDispositivoRepositoryData;
		this.logDispositivoMapper = logDispositivoMapper;
	}

	@Override
	public void save(LogDispositivo logDispositivo) {
		logDispositivoRepositoryData.save(logDispositivoMapper.mapToEntity(logDispositivo));
	}

}
