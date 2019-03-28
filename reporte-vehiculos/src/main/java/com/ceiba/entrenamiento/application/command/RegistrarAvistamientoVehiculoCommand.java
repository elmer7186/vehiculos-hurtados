package com.ceiba.entrenamiento.application.command;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.entrenamiento.domain.ReporteService;

@Service
public class RegistrarAvistamientoVehiculoCommand {

	private ReporteService reporteService;

	@Autowired
	public RegistrarAvistamientoVehiculoCommand(ReporteService serviciosDeReporte) {
		this.reporteService = serviciosDeReporte;
	}

	public void execute(String placa, String imei, String foto, Date fecha) {
		reporteService.registrarAvistamiento(placa, imei, foto, fecha);
	}

}
