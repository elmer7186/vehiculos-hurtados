package com.ceiba.entrenamiento.application.dto;

public class LogDispositivoDto {

	private String imei;
	private String estado;
	private String detalle;

	public LogDispositivoDto() {
		super();
	}

	public LogDispositivoDto(String imei, String estado, String detalle) {
		super();
		this.imei = imei;
		this.estado = estado;
		this.detalle = detalle;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
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
