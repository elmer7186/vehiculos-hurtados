package com.ceiba.entrenamiento.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.entrenamiento.application.command.AsociarRolesUsuarioCommand;
import com.ceiba.entrenamiento.application.dto.RolUsuarioDto;
import com.ceiba.entrenamiento.application.query.ListarRolesUsuarioQuery;
import com.ceiba.entrenamiento.domain.entity.RolUsuario;

@RestController
@RequestMapping("rolesUsuario")
public class RolUsuarioController {

	private AsociarRolesUsuarioCommand asociarRolesUsuarioCommand;
	private ListarRolesUsuarioQuery listarRolesUsuarioQuery;

	@Autowired
	public RolUsuarioController(AsociarRolesUsuarioCommand asociarRolesUsuarioCommand,
			ListarRolesUsuarioQuery listarRolesUsuarioQuery) {
		this.asociarRolesUsuarioCommand = asociarRolesUsuarioCommand;
		this.listarRolesUsuarioQuery = listarRolesUsuarioQuery;
	}

	@PostMapping
	public void asociarRolesUsuario(@RequestBody RolUsuarioDto rolUsuarioDto) {
		asociarRolesUsuarioCommand.execute(rolUsuarioDto);
	}

	@GetMapping
	public List<RolUsuario> listarRolesUsuario(String usuario) {
		return listarRolesUsuarioQuery.execute(usuario);
	}

}
