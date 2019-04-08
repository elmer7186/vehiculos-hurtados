package com.ceiba.entrenamiento.infrastructure.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.entrenamiento.domain.entity.Reporte;
import com.ceiba.entrenamiento.infrastructure.entity.ReporteEntity;

@Component
public class ReporteMapper {

	@Autowired
	private DispositivoMapper dispositivoMapper;

	@Autowired
	private VehiculoMapper vehiculoMapper;

	public ReporteEntity mapToEntity(Reporte reporte) {
		return new ReporteEntity(reporte.getId(), dispositivoMapper.mapToEntity(reporte.getDispositivo()),
				vehiculoMapper.mapToEntity(reporte.getVehiculo()), reporte.getFoto(), reporte.getFecha());
	}

	public Reporte mapToDomain(ReporteEntity reporteEntity) {
		return new Reporte(reporteEntity.getId(), dispositivoMapper.mapToDomain(reporteEntity.getDispositivo()),
				vehiculoMapper.mapToDomain(reporteEntity.getVehiculo()), reporteEntity.getFoto(),
				reporteEntity.getFecha());
	}
}
