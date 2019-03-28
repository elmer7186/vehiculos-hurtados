package com.ceiba.entrenamiento.infrastructure.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.entrenamiento.domain.entity.Reporte;
import com.ceiba.entrenamiento.domain.port.ReporteRepository;
import com.ceiba.entrenamiento.infrastructure.mapper.ReporteMapper;
import com.ceiba.entrenamiento.infrastructure.repository.ReporteRepositoryData;

@Repository
public class ReporteAdapter implements ReporteRepository {

	private ReporteRepositoryData reporteRepositoryData;
	private ReporteMapper reporteMapper;

	@Autowired
	public ReporteAdapter(ReporteRepositoryData reporteRepositoryData, ReporteMapper reporteMapper) {
		this.reporteRepositoryData = reporteRepositoryData;
		this.reporteMapper = reporteMapper;
	}

	@Override
	public void save(Reporte reporte) {
		reporteRepositoryData.save(reporteMapper.mapToEntity(reporte));
	}

}
