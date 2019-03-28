package com.ceiba.entrenamiento.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entrenamiento.infrastructure.entity.CiudadEntity;

@Repository
public interface CiudadRepositoryData extends MongoRepository<CiudadEntity, Long> {

	CiudadEntity findByCodigo(String codigo);

}
