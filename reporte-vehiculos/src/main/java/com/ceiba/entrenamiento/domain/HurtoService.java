package com.ceiba.entrenamiento.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.entrenamiento.domain.entity.Hurto;
import com.ceiba.entrenamiento.domain.entity.Vehiculo;
import com.ceiba.entrenamiento.domain.port.HurtoRepository;
import com.ceiba.entrenamiento.domain.port.VehiculoRepository;

@Service
public class HurtoService {

	private VehiculoRepository vehiculoRepository;
	private HurtoRepository hurtoRepository;

	@Autowired
	public HurtoService(VehiculoRepository vehiculoRepository, HurtoRepository hurtoRepository) {
		this.vehiculoRepository = vehiculoRepository;
		this.hurtoRepository = hurtoRepository;
	}

	public void registrarHurtoVehiculo(Hurto hurto) {
		Vehiculo vehiculoHurto = hurto.getVehiculo();
		Vehiculo vehiculoConsulta = vehiculoRepository.findByPlaca(hurto.getVehiculo().getPlaca());
		if (vehiculoConsulta != null) {
			vehiculoHurto.setId(vehiculoConsulta.getId());
			vehiculoRepository.save(vehiculoHurto);
			hurto.setVehiculo(vehiculoHurto);
		}
		hurtoRepository.save(hurto);
	}

}
