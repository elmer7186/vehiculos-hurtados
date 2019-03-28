package com.ceiba.entrenamiento.domain.port;

import com.ceiba.entrenamiento.domain.entity.Dispositivo;

public interface DispositivoRepository {

	Dispositivo findByImei(String imei);

}
