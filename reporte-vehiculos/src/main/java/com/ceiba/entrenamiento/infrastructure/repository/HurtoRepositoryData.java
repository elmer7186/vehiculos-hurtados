package com.ceiba.entrenamiento.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.entrenamiento.infrastructure.entity.HurtoEntity;

@Repository
public interface HurtoRepositoryData extends MongoRepository<HurtoEntity, String> {

}
