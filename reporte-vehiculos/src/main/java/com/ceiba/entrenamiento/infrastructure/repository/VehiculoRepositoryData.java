package com.ceiba.entrenamiento.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entrenamiento.infrastructure.entity.VehiculoEntity;

@Repository
public interface VehiculoRepositoryData extends MongoRepository<VehiculoEntity, Long> {

	VehiculoEntity findByPlaca(String placa);

}
