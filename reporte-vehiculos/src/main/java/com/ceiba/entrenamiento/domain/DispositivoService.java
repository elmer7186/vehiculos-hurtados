package com.ceiba.entrenamiento.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.entrenamiento.domain.entity.Dispositivo;
import com.ceiba.entrenamiento.domain.port.DispositivoRepository;

@Service
public class DispositivoService {

	private DispositivoRepository dispositivoRepository;

	@Autowired
	public DispositivoService(DispositivoRepository dispositivoRepository) {
		super();
		this.dispositivoRepository = dispositivoRepository;
	}

	public void guardarDispositivo(Dispositivo dispositivoGuardar) {
		Dispositivo dispositivoExistente = dispositivoRepository.findByImei(dispositivoGuardar.getImei());
		if (dispositivoExistente != null) {
			dispositivoGuardar.setId(dispositivoExistente.getId());
		}
		dispositivoRepository.save(dispositivoGuardar);
	}

}
