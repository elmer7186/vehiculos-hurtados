package com.ceiba.entrenamiento.infrastructure.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.entrenamiento.domain.entity.Reporte;
import com.ceiba.entrenamiento.infrastructure.entity.ReporteEntity;

@Component
public class ReporteMapper {

	@Autowired
	private DispositivoMapper dispositivoMapper;

	public ReporteEntity mapToEntity(Reporte reporte) {
		return new ReporteEntity(reporte.getId(), dispositivoMapper.mapToEntity(reporte.getDispositivo()),
				reporte.getFoto(), reporte.getFecha());
	}
}
