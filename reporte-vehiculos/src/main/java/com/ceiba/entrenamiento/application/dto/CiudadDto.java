package com.ceiba.entrenamiento.application.dto;

public class CiudadDto {

	private String nombre;
	private String codigo;
	private String codigoPais;

	public CiudadDto(String nombre, String codigo, String codigoPais) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.codigoPais = codigoPais;
	}

	public CiudadDto() {
		super();
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

	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

}
