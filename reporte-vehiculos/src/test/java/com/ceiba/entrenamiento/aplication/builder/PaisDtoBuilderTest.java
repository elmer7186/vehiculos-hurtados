package com.ceiba.entrenamiento.aplication.builder;

import com.ceiba.entrenamiento.application.dto.PaisDto;

public class PaisDtoBuilderTest {

	private String nombre;
	private String codigo;

	public PaisDtoBuilderTest() {
		super();
	}

	public static PaisDtoBuilderTest defaultValues() {
		return new PaisDtoBuilderTest();
	}

	public PaisDtoBuilderTest withNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public PaisDtoBuilderTest withCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	public PaisDto build() {
		return new PaisDto(this.nombre, this.codigo);
	}

}
