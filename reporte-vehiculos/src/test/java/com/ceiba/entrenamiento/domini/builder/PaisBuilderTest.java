package com.ceiba.entrenamiento.domini.builder;

import com.ceiba.entrenamiento.domain.entity.Pais;

public class PaisBuilderTest {
	private String id;
	private String codigo;
	private String nombre;

	private PaisBuilderTest() {
		super();
	}

	public static PaisBuilderTest defaultValues() {
		return new PaisBuilderTest();
	}

	public PaisBuilderTest withId(String id) {
		this.id = id;
		return this;
	}

	public PaisBuilderTest withCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	public PaisBuilderTest withNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public Pais build() {
		return new Pais(this.id, this.codigo, this.nombre);
	}

}
