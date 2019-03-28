package com.ceiba.entrenamiento.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.entrenamiento.application.command.RegistrarDenunciaDeHurtoCommand;
import com.ceiba.entrenamiento.application.dto.HurtoDto;

@RestController
@RequestMapping("hurtos")
public class HurtoController {

	private RegistrarDenunciaDeHurtoCommand registrarDenunciaDeHurtoCommand;

	@Autowired
	public HurtoController(RegistrarDenunciaDeHurtoCommand registrarDenunciaDeHurto) {
		this.registrarDenunciaDeHurtoCommand = registrarDenunciaDeHurto;
	}

	@PostMapping
	public void registrarHurto(@RequestBody HurtoDto hurtoDto) {
		registrarDenunciaDeHurtoCommand.execute(hurtoDto);
	}
}
