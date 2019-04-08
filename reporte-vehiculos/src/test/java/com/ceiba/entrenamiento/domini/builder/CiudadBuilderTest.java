package com.ceiba.entrenamiento.domini.builder;

import com.ceiba.entrenamiento.domain.entity.Ciudad;
import com.ceiba.entrenamiento.domain.entity.Pais;

public class CiudadBuilderTest {

	private String nombre;
	private String codigo;
	private Pais pais;

	public CiudadBuilderTest() {
		super();
	}

	public static CiudadBuilderTest defaultValues() {
		return new CiudadBuilderTest();
	}

	public CiudadBuilderTest withNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public CiudadBuilderTest withCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	public CiudadBuilderTest withPais(Pais pais) {
		this.pais = pais;
		return this;
	}

	public Ciudad build() {
		return new Ciudad(null, this.pais, this.codigo, this.nombre);
	}

}
