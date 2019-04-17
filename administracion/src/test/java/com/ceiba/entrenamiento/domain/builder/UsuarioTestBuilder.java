package com.ceiba.entrenamiento.domain.builder;

import java.util.Date;

import com.ceiba.entrenamiento.domain.entity.Usuario;

public class UsuarioTestBuilder {

	private long id;
	private String nombre;
	private String clave;
	private String email;
	private boolean habilitado;
	private Date vencimiento;

	public UsuarioTestBuilder() {
		super();
	}

	public static UsuarioTestBuilder defaultValues() {
		return new UsuarioTestBuilder();
	}

	public UsuarioTestBuilder withId(long id) {
		this.id = id;
		return this;
	}

	public UsuarioTestBuilder withNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public UsuarioTestBuilder withClave(String clave) {
		this.clave = clave;
		return this;
	}

	public UsuarioTestBuilder withEmail(String email) {
		this.email = email;
		return this;
	}

	public UsuarioTestBuilder withHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
		return this;
	}

	public UsuarioTestBuilder withVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
		return this;
	}

	public Usuario build() {
		return new Usuario(id, nombre, clave, email, habilitado, vencimiento);
	}

}
