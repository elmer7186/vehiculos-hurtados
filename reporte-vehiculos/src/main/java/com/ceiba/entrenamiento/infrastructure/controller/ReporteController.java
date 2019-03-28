package com.ceiba.entrenamiento.infrastructure.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.entrenamiento.application.command.RegistrarAvistamientoVehiculoCommand;

@RestController
@RequestMapping("reportes")
public class ReporteController {

	private RegistrarAvistamientoVehiculoCommand registrarAvistamientoVehiculoCommand;

	@Autowired
	public ReporteController(RegistrarAvistamientoVehiculoCommand registrarAvistamientoVehiculo) {
		this.registrarAvistamientoVehiculoCommand = registrarAvistamientoVehiculo;
	}

	@PostMapping
	public void registrarAvistamiento(String placa, String imei, String foto, Date fecha) {
		registrarAvistamientoVehiculoCommand.execute(placa, imei, foto, fecha);
	}

}
