package com.ceiba.entrenamiento.application.dto;

public class PaisDto {

	String nombre;
	String codigo;

	public PaisDto() {
		super();
	}

	public PaisDto(String nombre, String codigo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
