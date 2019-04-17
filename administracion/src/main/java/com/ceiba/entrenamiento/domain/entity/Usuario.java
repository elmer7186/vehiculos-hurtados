package com.ceiba.entrenamiento.domain.entity;

import java.util.Date;

public class Usuario {

	public static final String MENSAJE_NOMBRE_USUARIO_REQUERIDO = "El nombre de usuario es requerido";
	public static final String MENSAJE_CLAVE_USUARIO_REQUERIDA = "La clave de usuario es requerida";
	public static final String MENSAJE_EMAIL_USUARIO_REQUERIDO = "La correo de usuario es requerido";

	private long id;
	private String nombre;
	private String clave;
	private String email;
	private boolean habilitado;
	private Date vencimiento;

	public Usuario(long id, String nombre, String clave, String email, boolean habilitado, Date vencimiento) {
		ArgumentValidator.validateRequired(nombre, MENSAJE_NOMBRE_USUARIO_REQUERIDO);
		ArgumentValidator.validateRequired(clave, MENSAJE_CLAVE_USUARIO_REQUERIDA);
		ArgumentValidator.validateRequired(email, MENSAJE_EMAIL_USUARIO_REQUERIDO);
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
		this.email = email;
		this.habilitado = habilitado;
		this.vencimiento = vencimiento;
	}

	public Usuario(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public Date getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

}
