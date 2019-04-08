package com.ceiba.entrenamiento.aplication.builder;

import com.ceiba.entrenamiento.application.dto.LogDispositivoDto;

public class LogDispositivoDtoBuilderTest {

	private String imei;
	private String estado;
	private String detalle;

	private LogDispositivoDtoBuilderTest() {
		super();
	}

	public static LogDispositivoDtoBuilderTest defaultValues() {
		return new LogDispositivoDtoBuilderTest();
	}

	public LogDispositivoDtoBuilderTest withImei(String imei) {
		this.imei = imei;
		return this;
	}

	public LogDispositivoDtoBuilderTest withEstado(String estado) {
		this.estado = estado;
		return this;
	}

	public LogDispositivoDtoBuilderTest withDetalle(String detalle) {
		this.detalle = detalle;
		return this;
	}

	public LogDispositivoDto build() {
		return new LogDispositivoDto(imei, estado, detalle);
	}

}
