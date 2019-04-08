package com.ceiba.entrenamiento.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entrenamiento.infrastructure.entity.PaisEntity;

@Repository
public interface PaisRepositoryData extends MongoRepository<PaisEntity, String> {

	PaisEntity findByCodigo(String codigo);

}
