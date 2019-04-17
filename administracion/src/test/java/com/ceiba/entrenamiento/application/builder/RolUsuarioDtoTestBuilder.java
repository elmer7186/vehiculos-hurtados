package com.ceiba.entrenamiento.application.builder;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.entrenamiento.application.dto.RolUsuarioDto;

public class RolUsuarioDtoTestBuilder {
	private String usuario;
	private List<String> roles;

	public RolUsuarioDtoTestBuilder() {
		super();
	}

	public static RolUsuarioDtoTestBuilder defaultValues() {
		return new RolUsuarioDtoTestBuilder();
	}

	public RolUsuarioDtoTestBuilder withUsuario(String usuario) {
		this.usuario = usuario;
		return this;
	}

	public RolUsuarioDtoTestBuilder withRoles(List<String> roles) {
		this.roles = roles;
		return this;
	}

	public RolUsuarioDtoTestBuilder withRol(String rol) {
		if (this.roles == null) {
			this.roles = new ArrayList<>();
		}
		this.roles.add(rol);
		return this;
	}

	public RolUsuarioDto build() {
		return new RolUsuarioDto(usuario, roles);
	}
}
