package com.ceiba.entrenamiento.aplication.builder;

import java.util.Date;

import com.ceiba.entrenamiento.application.dto.HurtoDto;

public class HurtoDtoBuilderTest {

	private String placa;
	private String tipo;
	private String color;
	private String modelo;
	private String marca;
	private Date fechaHurto;
	private String descripcion;
	private String codigoCiudad;

	public HurtoDtoBuilderTest() {
		super();
	}

	public static HurtoDtoBuilderTest defaultValues() {
		return new HurtoDtoBuilderTest();
	}

	public HurtoDtoBuilderTest withPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public HurtoDtoBuilderTest withTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}

	public HurtoDtoBuilderTest withColor(String color) {
		this.color = color;
		return this;
	}

	public HurtoDtoBuilderTest withModelo(String modelo) {
		this.modelo = modelo;
		return this;
	}

	public HurtoDtoBuilderTest withMarca(String marca) {
		this.marca = marca;
		return this;
	}

	public HurtoDtoBuilderTest withFechaHurto(Date fechaHurto) {
		this.fechaHurto = fechaHurto;
		return this;
	}

	public HurtoDtoBuilderTest withDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public HurtoDtoBuilderTest withCodigoCiudad(String codigoCiudad) {
		this.codigoCiudad = codigoCiudad;
		return this;
	}

	public HurtoDto build() {
		HurtoDto hurtoDto = new HurtoDto();
		hurtoDto.setPlaca(this.placa);
		hurtoDto.setTipo(this.tipo);
		hurtoDto.setColor(this.color);
		hurtoDto.setModelo(this.modelo);
		hurtoDto.setMarca(this.marca);
		hurtoDto.setFechaHurto(this.fechaHurto);
		hurtoDto.setDescripcion(this.descripcion);
		hurtoDto.setCodigoCiudad(this.codigoCiudad);
		return hurtoDto;
	}
}
