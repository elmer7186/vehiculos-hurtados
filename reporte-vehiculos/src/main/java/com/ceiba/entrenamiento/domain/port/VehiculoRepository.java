package com.ceiba.entrenamiento.domain.port;

import com.ceiba.entrenamiento.domain.entity.Vehiculo;

public interface VehiculoRepository {

	Vehiculo findByPlaca(String placa);

	void save(Vehiculo vehiculo);

}
