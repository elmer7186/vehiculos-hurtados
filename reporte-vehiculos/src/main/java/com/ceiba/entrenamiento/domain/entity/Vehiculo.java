package com.ceiba.entrenamiento.domain.entity;

public class Vehiculo {

	public static final String MENSAJE_PLACA_REQUERIDA = "La placa es requerida";

	private String id;
	private String placa;
	private String marca;
	private String tipo;
	private String color;
	private String modelo;

	public Vehiculo() {
		super();
	}

	public Vehiculo(String placa) {
		super();
		ArgumentValidator.validateRequired(placa, MENSAJE_PLACA_REQUERIDA);
		this.placa = placa;
	}

	public Vehiculo(String id, String placa, String marca, String tipo, String color, String modelo) {
		super();
		ArgumentValidator.validateRequired(placa, MENSAJE_PLACA_REQUERIDA);
		this.id = id;
		this.placa = placa;
		this.marca = marca;
		this.tipo = tipo;
		this.color = color;
		this.modelo = modelo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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

}
