package com.ceiba.entrenamiento.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.entrenamiento.application.command.RegistrarAvistamientoVehiculoCommand;
import com.ceiba.entrenamiento.application.dto.AvistamientoDto;

@RestController
@RequestMapping("reportes")
public class ReporteController {

	private RegistrarAvistamientoVehiculoCommand registrarAvistamientoVehiculoCommand;

	@Autowired
	public ReporteController(RegistrarAvistamientoVehiculoCommand registrarAvistamientoVehiculo) {
		this.registrarAvistamientoVehiculoCommand = registrarAvistamientoVehiculo;
	}

	@PostMapping
	public void registrarAvistamiento(@RequestBody AvistamientoDto avistamiento) {
		registrarAvistamientoVehiculoCommand.execute(avistamiento);
	}

}
