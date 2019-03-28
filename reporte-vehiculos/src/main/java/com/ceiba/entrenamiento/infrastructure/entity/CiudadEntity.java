package com.ceiba.entrenamiento.infrastructure.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ciudad")
public class CiudadEntity {

	@Id
	private String id;
	private PaisEntity pais;
	private String codigo;
	private String nombre;

	public CiudadEntity() {
		super();
	}

	public CiudadEntity(String id, PaisEntity pais, String codigo, String nombre) {
		super();
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

	public PaisEntity getPais() {
		return pais;
	}

	public void setPais(PaisEntity pais) {
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
