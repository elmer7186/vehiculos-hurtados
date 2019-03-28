package com.ceiba.entrenamiento.infrastructure.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hurto")
public class HurtoEntity {

	@Id
	private String id;
	private VehiculoEntity vehiculo;
	private CiudadEntity ciudad;
	private Date fechaHurto;
	private String descripcion;

	public HurtoEntity() {
		super();
	}

	public HurtoEntity(String id, VehiculoEntity vehiculo, CiudadEntity ciudad, Date fechaHurto, String descripcion) {
		super();
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

	public VehiculoEntity getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoEntity vehiculo) {
		this.vehiculo = vehiculo;
	}

	public CiudadEntity getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadEntity ciudad) {
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
