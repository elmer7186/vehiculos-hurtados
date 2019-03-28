package com.ceiba.entrenamiento.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.entrenamiento.application.command.CrearEditarPaisCommand;
import com.ceiba.entrenamiento.application.dto.PaisDto;

@RestController
@RequestMapping("paises")
public class PaisController {

	private CrearEditarPaisCommand crearEditarPaisCommand;

	@Autowired
	public PaisController(CrearEditarPaisCommand crearEditarPaisCommand) {
		this.crearEditarPaisCommand = crearEditarPaisCommand;
	}

	@PostMapping
	public void guardarPais(@RequestBody PaisDto paisDto) {
		crearEditarPaisCommand.execute(paisDto);
	}

}
