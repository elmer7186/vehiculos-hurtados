package com.ceiba.entrenamiento.infrastructure.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.entrenamiento.domain.entity.Dispositivo;
import com.ceiba.entrenamiento.domain.port.DispositivoRepository;
import com.ceiba.entrenamiento.infrastructure.mapper.DispositivoMapper;
import com.ceiba.entrenamiento.infrastructure.repository.DispositivoRepositoryData;

@Repository
public class DispositivoAdapter implements DispositivoRepository {

	private DispositivoRepositoryData dispositivoRepositoryData;
	private DispositivoMapper dispositivoMapper;

	@Autowired
	public DispositivoAdapter(DispositivoRepositoryData dispositivoRepositoryData,
			DispositivoMapper dispositivoMapper) {
		this.dispositivoRepositoryData = dispositivoRepositoryData;
		this.dispositivoMapper = dispositivoMapper;
	}

	@Override
	public Dispositivo findByImei(String imei) {
		return dispositivoMapper.mapToDomain(dispositivoRepositoryData.findByImei(imei));
	}

	@Override
	public void save(Dispositivo dispositivo) {
		dispositivoRepositoryData.save(dispositivoMapper.mapToEntity(dispositivo));
	}

}
