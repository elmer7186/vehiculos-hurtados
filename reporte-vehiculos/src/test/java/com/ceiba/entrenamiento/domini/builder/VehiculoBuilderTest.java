package com.ceiba.entrenamiento.domini.builder;

import com.ceiba.entrenamiento.domain.entity.Vehiculo;

public class VehiculoBuilderTest {

	private String placa;
	private String marca;
	private String tipo;
	private String color;
	private String modelo;

	private VehiculoBuilderTest() {
		super();
	}

	public static VehiculoBuilderTest defaultValues() {
		return new VehiculoBuilderTest();
	}

	public VehiculoBuilderTest withPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public VehiculoBuilderTest withMarca(String marca) {
		this.marca = marca;
		return this;
	}

	public VehiculoBuilderTest withTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}

	public VehiculoBuilderTest withColor(String color) {
		this.color = color;
		return this;
	}

	public VehiculoBuilderTest withModelo(String modelo) {
		this.modelo = modelo;
		return this;
	}

	public Vehiculo build() {
		return new Vehiculo(null, placa, marca, tipo, color, modelo);
	}
}
