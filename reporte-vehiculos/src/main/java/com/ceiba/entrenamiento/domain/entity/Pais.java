package com.ceiba.entrenamiento.domain.entity;

public class Pais {

	public static final String MENSAJE_CODIGO_PAIS_REQUERIDO = "El codigo de pais es requerido";
	public static final String MENSAJE_NOMBRE_PAIS_REQUERIDO = "El nombre de pais es requerido";

	private String id;
	private String codigo;
	private String nombre;

	public Pais() {
		super();
	}

	public Pais(String id, String codigo, String nombre) {
		super();
		ArgumentValidator.validateRequired(codigo, MENSAJE_CODIGO_PAIS_REQUERIDO);
		ArgumentValidator.validateRequired(nombre, MENSAJE_NOMBRE_PAIS_REQUERIDO);
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
