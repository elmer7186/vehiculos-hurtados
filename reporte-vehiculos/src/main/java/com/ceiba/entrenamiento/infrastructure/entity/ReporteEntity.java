package com.ceiba.entrenamiento.infrastructure.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reporte")
public class ReporteEntity {

	@Id
	private String id;
	private DispositivoEntity dispositivo;
	private String foto;
	private Date fecha;

	public ReporteEntity() {
		super();
	}

	public ReporteEntity(String id, DispositivoEntity dispositivo, String foto, Date fecha) {
		super();
		this.id = id;
		this.dispositivo = dispositivo;
		this.foto = foto;
		this.fecha = fecha;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
