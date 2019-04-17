package com.ceiba.entrenamiento.domain.builder;

import com.ceiba.entrenamiento.domain.entity.Rol;

public class RolTestBuilder {

	private long id;
	private String nombre;
	private String descripcion;

	public RolTestBuilder() {
		super();
	}

	public static RolTestBuilder defaultValues() {
		return new RolTestBuilder();
	}

	public RolTestBuilder withId(long id) {
		this.id = id;
		return this;
	}

	public RolTestBuilder withNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public RolTestBuilder withDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public Rol build() {
		return new Rol(id, nombre, descripcion);
	}

}
