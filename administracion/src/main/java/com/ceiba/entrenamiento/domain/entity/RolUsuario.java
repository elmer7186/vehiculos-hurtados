package com.ceiba.entrenamiento.domain.entity;

public class RolUsuario {

	public static final String MENSAJE_USUARIO_REQUERIDO = "El usuario es requerido";
	public static final String MENSAJE_ROL_REQUERIDO = "EL rol es requerido";

	private long id;
	private Usuario usuario;
	private Rol rol;

	public RolUsuario(long id, Usuario usuario, Rol rol) {
		ArgumentValidator.validateRequired(usuario, MENSAJE_USUARIO_REQUERIDO);
		ArgumentValidator.validateRequired(rol, MENSAJE_ROL_REQUERIDO);
		this.id = id;
		this.usuario = usuario;
		this.rol = rol;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
