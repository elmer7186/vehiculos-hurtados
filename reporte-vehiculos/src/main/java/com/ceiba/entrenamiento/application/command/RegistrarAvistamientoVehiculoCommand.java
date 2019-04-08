package com.ceiba.entrenamiento.application.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.entrenamiento.application.dto.AvistamientoDto;
import com.ceiba.entrenamiento.domain.VehiculoService;
import com.ceiba.entrenamiento.domain.entity.Dispositivo;
import com.ceiba.entrenamiento.domain.entity.Reporte;
import com.ceiba.entrenamiento.domain.entity.Vehiculo;
import com.ceiba.entrenamiento.domain.port.DispositivoRepository;
import com.ceiba.entrenamiento.domain.port.ReporteRepository;

@Service
public class RegistrarAvistamientoVehiculoCommand {

	private VehiculoService vehiculoService;
	private ReporteRepository reporteRepository;
	private DispositivoRepository dispositivoRepository;

	@Autowired
	public RegistrarAvistamientoVehiculoCommand(VehiculoService vehiculoService, ReporteRepository reporteRepository,
			DispositivoRepository dispositivoRepository) {
		super();
		this.vehiculoService = vehiculoService;
		this.reporteRepository = reporteRepository;
		this.dispositivoRepository = dispositivoRepository;
	}

	public void execute(AvistamientoDto avistamientoDto) {
		Vehiculo vehiculo = vehiculoService.almacenarVehiculo(avistamientoDto.getPlaca());
		Dispositivo dispositivo = dispositivoRepository.findByImei(avistamientoDto.getImei());
		Reporte reporte = new Reporte(null, dispositivo, vehiculo, avistamientoDto.getFoto(),
				avistamientoDto.getFecha());
		reporteRepository.save(reporte);
	}

}
