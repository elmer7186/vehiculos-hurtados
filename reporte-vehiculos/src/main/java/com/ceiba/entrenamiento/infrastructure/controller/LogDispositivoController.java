package com.ceiba.entrenamiento.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.entrenamiento.application.command.RegistrarLogDispositivoCommand;

@RestController
@RequestMapping("logsDispositivos")
public class LogDispositivoController {

	private RegistrarLogDispositivoCommand registrarLogDispositivoCommand;

	@Autowired
	public LogDispositivoController(RegistrarLogDispositivoCommand registrarLogDispositivo) {
		this.registrarLogDispositivoCommand = registrarLogDispositivo;
	}

	@PostMapping
	public void registrarLogDispositivo(String imei, String estado, String detalle) {
		registrarLogDispositivoCommand.execute(imei, estado, detalle);
	}

}
