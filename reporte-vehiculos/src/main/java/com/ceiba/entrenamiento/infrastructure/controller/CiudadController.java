package com.ceiba.entrenamiento.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.entrenamiento.application.command.CrearEditarCiudadCommand;
import com.ceiba.entrenamiento.application.dto.CiudadDto;

@RestController
@RequestMapping("ciudades")
public class CiudadController {

	private CrearEditarCiudadCommand crearEditarCiudadCommand;

	@Autowired
	public CiudadController(CrearEditarCiudadCommand crearEditarCiudadCommand) {
		this.crearEditarCiudadCommand = crearEditarCiudadCommand;
	}

	@PostMapping
	public void guardarCiudad(@RequestBody CiudadDto ciudadDto) {
		crearEditarCiudadCommand.execute(ciudadDto);
	}
	
	@GetMapping
	public String test() {
		return "Me llamaron entonces respondí";
	}

}
