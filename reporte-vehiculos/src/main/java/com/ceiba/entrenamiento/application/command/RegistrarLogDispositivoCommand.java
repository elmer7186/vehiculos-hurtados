package com.ceiba.entrenamiento.application.command;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.entrenamiento.application.dto.LogDispositivoDto;
import com.ceiba.entrenamiento.domain.entity.Dispositivo;
import com.ceiba.entrenamiento.domain.entity.LogDispositivo;
import com.ceiba.entrenamiento.domain.port.DispositivoRepository;
import com.ceiba.entrenamiento.domain.port.LogDispositivoRepository;

@Service
public class RegistrarLogDispositivoCommand {

	private DispositivoRepository dispositivoRepository;
	private LogDispositivoRepository logDispositivoRepository;

	@Autowired
	public RegistrarLogDispositivoCommand(DispositivoRepository dispositivoRepository,
			LogDispositivoRepository logDispositivoRepository) {
		this.dispositivoRepository = dispositivoRepository;
		this.logDispositivoRepository = logDispositivoRepository;
	}

	public void execute(LogDispositivoDto logDispositivoDto) {
		Dispositivo dispositivo = dispositivoRepository.findByImei(logDispositivoDto.getImei());
		LogDispositivo logDispositivo = new LogDispositivo(null, dispositivo, logDispositivoDto.getEstado(),
				logDispositivoDto.getDetalle(), new Date());
		logDispositivoRepository.save(logDispositivo);
	}
}
