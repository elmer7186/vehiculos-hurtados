package com.ceiba.entrenamiento.application.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.entrenamiento.application.dto.HurtoDto;
import com.ceiba.entrenamiento.domain.VehiculoService;
import com.ceiba.entrenamiento.domain.entity.Ciudad;
import com.ceiba.entrenamiento.domain.entity.Hurto;
import com.ceiba.entrenamiento.domain.entity.Vehiculo;
import com.ceiba.entrenamiento.domain.port.CiudadRepository;
import com.ceiba.entrenamiento.domain.port.HurtoRepository;

@Service
public class RegistrarDenunciaDeHurtoCommand {

	private HurtoRepository hurtoRepository;
	private CiudadRepository ciudadRepository;
	private VehiculoService vehiculoService;

	@Autowired
	public RegistrarDenunciaDeHurtoCommand(HurtoRepository hurtoRepository, CiudadRepository ciudadRepository,
			VehiculoService vehiculoService) {
		this.hurtoRepository = hurtoRepository;
		this.ciudadRepository = ciudadRepository;
		this.vehiculoService = vehiculoService;
	}

	public Hurto execute(HurtoDto hurtoDto) {
		Vehiculo vehiculo = new Vehiculo(null, hurtoDto.getPlaca(), hurtoDto.getMarca(), hurtoDto.getTipo(),
				hurtoDto.getColor(), hurtoDto.getModelo());
		vehiculo = vehiculoService.almacenarVehiculo(vehiculo);
		Ciudad ciudad = ciudadRepository.findByCodigo(hurtoDto.getCodigoCiudad());
		Hurto hurto = new Hurto(null, vehiculo, ciudad, hurtoDto.getFechaHurto(), hurtoDto.getDescripcion());
		return hurtoRepository.save(hurto);
	}

}
