package com.ceiba.entrenamiento.infrastructure.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "logDispositivo")
public class LogDispositivoEntity {

	@Id
	private String id;
	private DispositivoEntity dispositivo;
	private String estado;
	private String detalle;

	public LogDispositivoEntity() {
		super();
	}

	public LogDispositivoEntity(String id, DispositivoEntity dispositivo, String estado, String detalle) {
		super();
		this.id = id;
		this.dispositivo = dispositivo;
		this.estado = estado;
		this.detalle = detalle;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DispositivoEntity getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(DispositivoEntity dispositivo) {
		this.dispositivo = dispositivo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

}
