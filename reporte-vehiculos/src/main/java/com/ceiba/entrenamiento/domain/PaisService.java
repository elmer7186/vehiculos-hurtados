package com.ceiba.entrenamiento.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.entrenamiento.domain.entity.Pais;
import com.ceiba.entrenamiento.domain.port.PaisRepository;

@Service
public class PaisService {

	private PaisRepository paisRepository;

	@Autowired
	public PaisService(PaisRepository paisRepository) {
		this.paisRepository = paisRepository;
	}

	public void almacenarPais(Pais pais) {
		Pais paisConsulta = paisRepository.findByCodigo(pais.getCodigo());
		if (paisConsulta != null) {
			pais.setId(paisConsulta.getId());
		}
		paisRepository.save(pais);
	}

}
