package com.ceiba.entrenamiento.aplication.builder;

import com.ceiba.entrenamiento.application.dto.CiudadDto;

public class CiudadDtoBuilderTest {

	private String nombre;
	private String codigo;
	private String codigoPais;

	public CiudadDtoBuilderTest() {
		super();
	}

	public static CiudadDtoBuilderTest defaultValues() {
		return new CiudadDtoBuilderTest();
	}

	public CiudadDtoBuilderTest withNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public CiudadDtoBuilderTest withCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	public CiudadDtoBuilderTest withCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
		return this;
	}

	public CiudadDto build() {
		return new CiudadDto(this.nombre, this.codigo, this.codigoPais);
	}

}
