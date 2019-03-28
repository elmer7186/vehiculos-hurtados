package com.ceiba.entrenamiento.domain;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.entrenamiento.domain.entity.Dispositivo;
import com.ceiba.entrenamiento.domain.entity.Reporte;
import com.ceiba.entrenamiento.domain.entity.Vehiculo;
import com.ceiba.entrenamiento.domain.port.DispositivoRepository;
import com.ceiba.entrenamiento.domain.port.ReporteRepository;
import com.ceiba.entrenamiento.domain.port.VehiculoRepository;

@Service
public class ReporteService {

	private VehiculoRepository vehiculoRepository;
	private DispositivoRepository dispositivoRepository;
	private ReporteRepository reporteRepository;

	@Autowired
	public ReporteService(VehiculoRepository vehiculoRepository, DispositivoRepository dispositivoRepository,
			ReporteRepository reporteRepository) {
		this.vehiculoRepository = vehiculoRepository;
		this.dispositivoRepository = dispositivoRepository;
		this.reporteRepository = reporteRepository;
	}

	@Transactional
	public void registrarAvistamiento(String placa, String imei, String foto, Date fecha) {
		Vehiculo vehiculo = vehiculoRepository.findByPlaca(placa);
		if (vehiculo == null) {
			vehiculo = new Vehiculo(placa);
			vehiculoRepository.save(vehiculo);
		}
		Dispositivo dispositivo = dispositivoRepository.findByImei(imei);
		Reporte reporte = new Reporte(null, dispositivo, vehiculo, foto, fecha);
		reporteRepository.save(reporte);
	}

}
