package com.ceiba.entrenamiento.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.ceiba.entrenamiento.domain.entity.Vehiculo;
import com.ceiba.entrenamiento.infrastructure.entity.VehiculoEntity;

@Component
public class VehiculoMapper {

	public Vehiculo mapToDomain(VehiculoEntity vehiculoEntity) {
		Vehiculo vehiculoRetorno = null;
		if (vehiculoEntity != null) {
			vehiculoRetorno = new Vehiculo(vehiculoEntity.getId(), vehiculoEntity.getPlaca(), vehiculoEntity.getMarca(),
					vehiculoEntity.getTipo(), vehiculoEntity.getColor(), vehiculoEntity.getModelo());
		}
		return vehiculoRetorno;
	}

	public VehiculoEntity mapToEntity(Vehiculo vehiculo) {
		VehiculoEntity vehiculoRetorno = null;
		if (vehiculo != null) {
			vehiculoRetorno = new VehiculoEntity(vehiculo.getId(), vehiculo.getPlaca(), vehiculo.getMarca(),
					vehiculo.getTipo(), vehiculo.getColor(), vehiculo.getModelo());
		}
		return vehiculoRetorno;
	}

}
