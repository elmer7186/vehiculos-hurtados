package com.ceiba.entrenamiento.domain.entity;

import java.util.Date;

public class Reporte {

	public static final String MENSAJE_DISPOSITIVO_REQUERIDO = "El dispositivo es requerido";
	public static final String MENSAJE_VEHICULO_REQUERIDO = "El vehiculo es requerido";

	private String id;
	private Dispositivo dispositivo;
	private Vehiculo vehiculo;
	private String foto;
	private Date fecha;

	public Reporte() {
		super();
	}

	public Reporte(String id, Dispositivo dispositivo, Vehiculo vehiculo, String foto, Date fecha) {
		super();
		ArgumentValidator.validateRequired(dispositivo, MENSAJE_DISPOSITIVO_REQUERIDO);
		ArgumentValidator.validateRequired(vehiculo, MENSAJE_VEHICULO_REQUERIDO);
		this.id = id;
		this.dispositivo = dispositivo;
		this.vehiculo = vehiculo;
		this.foto = foto;
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

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
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
