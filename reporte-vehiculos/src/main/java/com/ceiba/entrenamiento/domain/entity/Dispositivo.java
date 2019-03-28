package com.ceiba.entrenamiento.domain.entity;

public class Dispositivo {

	private String id;
	private Ciudad ciudad;
	private String imei;
	private String ubicacionGps;
	private String descripcion;
	private boolean habilitado;

	public Dispositivo(String id, Ciudad ciudad, String imei, String ubicacionGps, String descripcion,
			boolean habilitado) {
		super();
		this.id = id;
		this.ciudad = ciudad;
		this.imei = imei;
		this.ubicacionGps = ubicacionGps;
		this.descripcion = descripcion;
		this.habilitado = habilitado;
	}

	public Dispositivo() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getUbicacionGps() {
		return ubicacionGps;
	}

	public void setUbicacionGps(String ubicacionGps) {
		this.ubicacionGps = ubicacionGps;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

}
