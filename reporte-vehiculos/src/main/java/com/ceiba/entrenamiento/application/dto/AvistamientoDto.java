package com.ceiba.entrenamiento.application.dto;

import java.util.Date;

public class AvistamientoDto {

	private String placa;
	private String imei;
	private String foto;
	private Date fecha;

	public AvistamientoDto() {
		super();
	}

	public AvistamientoDto(String placa, String imei, String foto, Date fecha) {
		super();
		this.placa = placa;
		this.imei = imei;
		this.foto = foto;
		this.fecha = fecha;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
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
