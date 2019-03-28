package com.ceiba.entrenamiento.domain.entity;

import com.ceiba.entrenamiento.domain.exception.ReporteVehiculosException;

public class ArgumentValidator {

	private ArgumentValidator() {
		/// constructor vacio clase de utilidad
	}

	public static void validateRequired(Object value, String message) {
		if (value == null) {
			throw new ReporteVehiculosException(message);
		}
	}
}
