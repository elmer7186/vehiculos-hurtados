package com.ceiba.entrenamiento.application.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.entrenamiento.application.dto.PaisDto;
import com.ceiba.entrenamiento.domain.PaisService;
import com.ceiba.entrenamiento.domain.entity.Pais;

@Service
public class CrearEditarPaisCommand {

	private PaisService paisService;

	@Autowired
	public CrearEditarPaisCommand(PaisService paisService) {
		this.paisService = paisService;
	}

	public void execute(PaisDto paisDto) {
		paisService.almacenarPais(new Pais(null, paisDto.getCodigo(), paisDto.getNombre()));
	}

}
