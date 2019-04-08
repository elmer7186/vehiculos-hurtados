package com.ceiba.entrenamiento.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.entrenamiento.domain.entity.Vehiculo;
import com.ceiba.entrenamiento.domain.port.VehiculoRepository;

@Service
public class VehiculoService {

	private VehiculoRepository vehiculoRepository;

	@Autowired
	public VehiculoService(VehiculoRepository vehiculoRepository) {
		super();
		this.vehiculoRepository = vehiculoRepository;
	}

	public Vehiculo almacenarVehiculo(String placa) {
		Vehiculo vehiculo = vehiculoRepository.findByPlaca(placa);
		if (vehiculo == null) {
			vehiculo = new Vehiculo(placa);
			vehiculo = vehiculoRepository.save(vehiculo);
		}
		return vehiculo;
	}

	public Vehiculo almacenarVehiculo(Vehiculo vehiculo) {
		Vehiculo vehiculoConsulta = vehiculoRepository.findByPlaca(vehiculo.getPlaca());
		if (vehiculoConsulta != null) {
			vehiculo.setId(vehiculoConsulta.getId());
		}
		return vehiculoRepository.save(vehiculo);
	}

}
