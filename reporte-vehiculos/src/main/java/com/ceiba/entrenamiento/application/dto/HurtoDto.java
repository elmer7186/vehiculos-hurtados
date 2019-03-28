package com.ceiba.entrenamiento.application.dto;

import java.util.Date;

public class HurtoDto {

	private String placa;
	private String tipo;
	private String color;
	private String modelo;
	private String marca;
	private Date fechaHurto;
	private String descripcion;
	private String ciudad;

	public HurtoDto() {
		super();
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Date getFechaHurto() {
		return fechaHurto;
	}

	public void setFechaHurto(Date fechaHurto) {
		this.fechaHurto = fechaHurto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

}
