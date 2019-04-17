package com.ceiba.entrenamiento.application.dto;

import java.util.List;

public class RolUsuarioDto {

	private String usuario;
	private List<String> roles;

	public RolUsuarioDto() {
		super();
	}

	public RolUsuarioDto(String usuario, List<String> roles) {
		super();
		this.usuario = usuario;
		this.roles = roles;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
