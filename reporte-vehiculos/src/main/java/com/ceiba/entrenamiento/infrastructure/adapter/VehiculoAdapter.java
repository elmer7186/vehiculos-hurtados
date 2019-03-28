package com.ceiba.entrenamiento.infrastructure.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.entrenamiento.domain.entity.Vehiculo;
import com.ceiba.entrenamiento.domain.port.VehiculoRepository;
import com.ceiba.entrenamiento.infrastructure.mapper.VehiculoMapper;
import com.ceiba.entrenamiento.infrastructure.repository.VehiculoRepositoryData;

@Repository
public class VehiculoAdapter implements VehiculoRepository {

	private VehiculoMapper vehiculoMapper;
	private VehiculoRepositoryData vehiculoRepositoryData;

	@Autowired
	public VehiculoAdapter(VehiculoMapper vehiculoMapper, VehiculoRepositoryData vehiculoRepositoryData) {
		this.vehiculoMapper = vehiculoMapper;
		this.vehiculoRepositoryData = vehiculoRepositoryData;
	}

	@Override
	public Vehiculo findByPlaca(String placa) {
		return vehiculoMapper.mapToDomain(vehiculoRepositoryData.findByPlaca(placa));
	}

	@Override
	public void save(Vehiculo vehiculo) {
		vehiculoRepositoryData.save(vehiculoMapper.mapToEntity(vehiculo));
	}

}
