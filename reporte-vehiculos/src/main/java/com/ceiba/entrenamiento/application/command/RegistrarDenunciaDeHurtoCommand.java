package com.ceiba.entrenamiento.application.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.entrenamiento.application.dto.HurtoDto;
import com.ceiba.entrenamiento.domain.HurtoService;
import com.ceiba.entrenamiento.domain.entity.Ciudad;
import com.ceiba.entrenamiento.domain.entity.Hurto;
import com.ceiba.entrenamiento.domain.entity.Vehiculo;
import com.ceiba.entrenamiento.domain.port.CiudadRepository;

@Service
public class RegistrarDenunciaDeHurtoCommand {

	private HurtoService hurtoService;
	private CiudadRepository ciudadRepository;

	@Autowired
	public RegistrarDenunciaDeHurtoCommand(HurtoService hurtoService, CiudadRepository ciudadRepository) {
		this.hurtoService = hurtoService;
		this.ciudadRepository = ciudadRepository;
	}

	public void execute(HurtoDto hurtoDto) {
		Vehiculo vehiculo = new Vehiculo(null, hurtoDto.getPlaca(), hurtoDto.getMarca(), hurtoDto.getTipo(),
				hurtoDto.getColor(), hurtoDto.getModelo());
		Ciudad ciudad = ciudadRepository.findByCodigo(hurtoDto.getCiudad());
		Hurto hurto = new Hurto(null, vehiculo, ciudad, hurtoDto.getFechaHurto(), hurtoDto.getDescripcion());
		hurtoService.registrarHurtoVehiculo(hurto);
	}

}
