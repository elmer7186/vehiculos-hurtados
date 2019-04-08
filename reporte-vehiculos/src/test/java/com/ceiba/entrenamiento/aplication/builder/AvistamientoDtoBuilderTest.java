package com.ceiba.entrenamiento.aplication.builder;

import java.util.Date;

import com.ceiba.entrenamiento.application.dto.AvistamientoDto;

public class AvistamientoDtoBuilderTest {
	private String placa;
	private String imei;
	private String foto;
	private Date fecha;

	private AvistamientoDtoBuilderTest() {
		super();
	}

	public static final AvistamientoDtoBuilderTest defaultValues() {
		return new AvistamientoDtoBuilderTest();
	}

	public AvistamientoDtoBuilderTest withPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public AvistamientoDtoBuilderTest withImei(String imei) {
		this.imei = imei;
		return this;
	}

	public AvistamientoDtoBuilderTest withFoto(String foto) {
		this.foto = foto;
		return this;
	}

	public AvistamientoDtoBuilderTest withFecha(Date fecha) {
		this.fecha = fecha;
		return this;
	}

	public AvistamientoDto build() {
		return new AvistamientoDto(this.placa, this.imei, this.foto, this.fecha);
	}

}
