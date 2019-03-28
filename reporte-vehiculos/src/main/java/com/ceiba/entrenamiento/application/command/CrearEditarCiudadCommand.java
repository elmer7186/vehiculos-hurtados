package com.ceiba.entrenamiento.application.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.entrenamiento.application.dto.CiudadDto;
import com.ceiba.entrenamiento.domain.CiudadService;
import com.ceiba.entrenamiento.domain.entity.Ciudad;
import com.ceiba.entrenamiento.domain.entity.Pais;
import com.ceiba.entrenamiento.domain.port.PaisRepository;

@Service
public class CrearEditarCiudadCommand {

	private CiudadService ciudadService;
	private PaisRepository paisRepository;

	@Autowired
	public CrearEditarCiudadCommand(CiudadService ciudadService, PaisRepository paisRepository) {
		this.ciudadService = ciudadService;
		this.paisRepository = paisRepository;
	}

	public void execute(CiudadDto ciudadDto) {
		Pais pais = paisRepository.findByCodigo(ciudadDto.getCodigoPais());
		ciudadService.almacenarCiudad(new Ciudad(null, pais, ciudadDto.getCodigo(), ciudadDto.getNombre()));
	}

}
