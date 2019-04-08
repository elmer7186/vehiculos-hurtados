package com.ceiba.entrenamiento.domini.builder;

import com.ceiba.entrenamiento.domain.entity.Ciudad;
import com.ceiba.entrenamiento.domain.entity.Dispositivo;

public class DispositivoBuilderTest {

	private Ciudad ciudad;
	private String imei;
	private String ubicacionGps;
	private String descripcion;
	private boolean habilitado;

	private DispositivoBuilderTest() {
		super();
	}

	public static DispositivoBuilderTest defaultValues() {
		return new DispositivoBuilderTest();
	}

	public DispositivoBuilderTest withCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
		return this;
	}

	public DispositivoBuilderTest withImei(String imei) {
		this.imei = imei;
		return this;
	}

	public DispositivoBuilderTest withUbicacionGps(String ubicacionGps) {
		this.ubicacionGps = ubicacionGps;
		return this;
	}

	public DispositivoBuilderTest withDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public DispositivoBuilderTest withHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
		return this;
	}

	public Dispositivo build() {
		return new Dispositivo(null, ciudad, imei, ubicacionGps, descripcion, habilitado);
	}

}
