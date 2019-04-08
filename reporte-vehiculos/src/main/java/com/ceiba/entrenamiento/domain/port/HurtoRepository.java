package com.ceiba.entrenamiento.domain.port;

import com.ceiba.entrenamiento.domain.entity.Hurto;

public interface HurtoRepository {

	Hurto save(Hurto hurto);

	Hurto findById(String idHurto);

}
