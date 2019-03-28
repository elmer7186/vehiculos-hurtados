package com.ceiba.entrenamiento.infrastructure.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.entrenamiento.domain.entity.Pais;
import com.ceiba.entrenamiento.domain.port.PaisRepository;
import com.ceiba.entrenamiento.infrastructure.entity.PaisEntity;
import com.ceiba.entrenamiento.infrastructure.mapper.PaisMapper;
import com.ceiba.entrenamiento.infrastructure.repository.PaisRepositoryData;

@Repository
public class PaisAdapter implements PaisRepository {

	private PaisRepositoryData paisRepositoryData;
	private PaisMapper paisMapper;

	@Autowired
	public PaisAdapter(PaisRepositoryData paisRepositoryData, PaisMapper paisMapper) {
		this.paisRepositoryData = paisRepositoryData;
		this.paisMapper = paisMapper;
	}

	@Override
	public void save(Pais pais) {
		paisRepositoryData.save(paisMapper.mapToEntity(pais));
	}

	@Override
	public Pais findByCodigo(String codigo) {
		Pais paisRetorno = null;
		PaisEntity paisEntity = paisRepositoryData.findByCodigo(codigo);
		if (paisEntity != null) {
			paisRetorno = paisMapper.mapToDomain(paisEntity);
		}
		return paisRetorno;
	}

}
