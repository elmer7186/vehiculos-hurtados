package com.ceiba.entrenamiento.domain.entity;

public class Rol {

	public static final String MENSAJE_NOMBRE_ROL_REQUERIDO = "El nombre del rol es requerido";

	private long id;
	private String nombre;
	private String descripcion;

	public Rol(long id, String nombre, String descripcion) {
		ArgumentValidator.validateRequired(nombre, MENSAJE_NOMBRE_ROL_REQUERIDO);
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Rol(long id) {
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
