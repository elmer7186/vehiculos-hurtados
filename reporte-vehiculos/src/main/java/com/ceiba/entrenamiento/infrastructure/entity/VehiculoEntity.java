package com.ceiba.entrenamiento.infrastructure.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehiculo")
public class VehiculoEntity {

	@Id
	private String id;
	private String placa;
	private String marca;
	private String tipo;
	private String color;
	private String modelo;

	public VehiculoEntity() {
		super();
	}

	public VehiculoEntity(String id, String placa, String marca, String tipo, String color, String modelo) {
		super();
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
