package com.ceiba.entrenamiento.domain.builder;

import com.ceiba.entrenamiento.domain.entity.Rol;
import com.ceiba.entrenamiento.domain.entity.RolUsuario;
import com.ceiba.entrenamiento.domain.entity.Usuario;

public class RolUsuarioTestBuilder {

	private Usuario usuario;
	private Rol rol;

	public RolUsuarioTestBuilder() {
		super();
	}

	public static RolUsuarioTestBuilder defaultValues() {
		return new RolUsuarioTestBuilder();
	}

	public RolUsuarioTestBuilder withUsuario(Usuario usuario) {
		this.usuario = usuario;
		return this;
	}

	public RolUsuarioTestBuilder withRol(Rol rol) {
		this.rol = rol;
		return this;
	}

	public RolUsuario build() {
		return new RolUsuario(0, usuario, rol);
	}

}
