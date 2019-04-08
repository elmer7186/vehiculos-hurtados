package com.ceiba.entrenamiento.domain.entity;

import java.util.Date;

public class Hurto {

	public static final String MENSAJE_VEHICULO_REQUERIDO = "El vehiculo es requerido";
	public static final String MENSAJE_CIUDAD_REQUERIDA = "La ciudad es requerida";
	public static final String MENSAJE_FECHA_HURTO_REQUERIDA = "La fecha de hurto es requerida";

	private String id;
	private Vehiculo vehiculo;
	private Ciudad ciudad;
	private Date fechaHurto;
	private String descripcion;

	public Hurto() {
		super();
	}

	public Hurto(String id, Vehiculo vehiculo, Ciudad ciudad, Date fechaHurto, String descripcion) {
		super();
		ArgumentValidator.validateRequired(vehiculo, MENSAJE_VEHICULO_REQUERIDO);
		ArgumentValidator.validateRequired(ciudad, MENSAJE_CIUDAD_REQUERIDA);
		ArgumentValidator.validateRequired(fechaHurto, MENSAJE_FECHA_HURTO_REQUERIDA);
		this.id = id;
		this.vehiculo = vehiculo;
		this.ciudad = ciudad;
		this.fechaHurto = fechaHurto;
		this.descripcion = descripcion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Date getFechaHurto() {
		return fechaHurto;
	}

	public void setFechaHurto(Date fechaHurto) {
		this.fechaHurto = fechaHurto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
