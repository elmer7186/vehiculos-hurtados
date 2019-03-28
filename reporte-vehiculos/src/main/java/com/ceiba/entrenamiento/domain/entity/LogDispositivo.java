package com.ceiba.entrenamiento.domain.entity;

import java.util.Date;

public class LogDispositivo {

	public static final String MENSAJE_DISPOSITIVO_REQUERIDO = "El dispositivo es requerido";
	public static final String MENSAJE_ESTADO_REQUERIDO = "El estado del dispositivo es requerido";

	private String id;
	private Dispositivo dispositivo;
	private String estado;
	private String detalle;
	private Date fecha;

	public LogDispositivo() {
		super();
	}

	public LogDispositivo(String id, Dispositivo dispositivo, String estado, String detalle, Date fecha) {
		super();
		ArgumentValidator.validateRequired(dispositivo, MENSAJE_DISPOSITIVO_REQUERIDO);
		ArgumentValidator.validateRequired(estado, MENSAJE_DISPOSITIVO_REQUERIDO);
		this.id = id;
		this.dispositivo = dispositivo;
		this.estado = estado;
		this.detalle = detalle;
		this.fecha = fecha;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
