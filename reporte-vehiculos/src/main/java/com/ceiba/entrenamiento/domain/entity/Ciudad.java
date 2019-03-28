package com.ceiba.entrenamiento.domain.entity;

public class Ciudad {

	private static final String MENSAJE_PAIS_REQUERIDO = "El país es requerido";
	private static final String MENSAJE_CODIGO_CIUDAD_REQUERIDO = "El codigo de ciudad es requerido";
	private static final String MENSAJE_NOMBRE_CIUDAD_REQUERIDO = "El nombre de ciudad es requerido";

	private String id;
	private Pais pais;
	private String codigo;
	private String nombre;

	public Ciudad() {
		super();
	}

	public Ciudad(String id) {
		super();
		this.id = id;
	}

	public Ciudad(String id, Pais pais, String codigo, String nombre) {
		super();
		ArgumentValidator.validateRequired(pais, MENSAJE_PAIS_REQUERIDO);
		ArgumentValidator.validateRequired(codigo, MENSAJE_CODIGO_CIUDAD_REQUERIDO);
		ArgumentValidator.validateRequired(nombre, MENSAJE_NOMBRE_CIUDAD_REQUERIDO);
		this.id = id;
		this.pais = pais;
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
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
