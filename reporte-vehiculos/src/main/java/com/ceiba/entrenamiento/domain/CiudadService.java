package com.ceiba.entrenamiento.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.entrenamiento.domain.entity.Ciudad;
import com.ceiba.entrenamiento.domain.port.CiudadRepository;

@Service
public class CiudadService {

	private CiudadRepository ciudadRepository;

	@Autowired
	public CiudadService(CiudadRepository ciudadRepository) {
		super();
		this.ciudadRepository = ciudadRepository;
	}

	public void almacenarCiudad(Ciudad ciudad) {
		Ciudad ciudadConsulta = ciudadRepository.findByCodigo(ciudad.getCodigo());
		if (ciudadConsulta != null) {
			ciudad.setId(ciudadConsulta.getId());
		}
		ciudadRepository.save(ciudad);
	}

}
