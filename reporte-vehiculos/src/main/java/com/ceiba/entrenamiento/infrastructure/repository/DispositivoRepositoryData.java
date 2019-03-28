package com.ceiba.entrenamiento.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entrenamiento.infrastructure.entity.DispositivoEntity;

@Repository
public interface DispositivoRepositoryData extends MongoRepository<DispositivoEntity, Long> {

	DispositivoEntity findByImei(String imei);
	
}
