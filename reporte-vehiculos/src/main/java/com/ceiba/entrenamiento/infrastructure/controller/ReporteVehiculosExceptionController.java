package com.ceiba.entrenamiento.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ceiba.entrenamiento.domain.exception.ReporteVehiculosException;

@ControllerAdvice
public class ReporteVehiculosExceptionController {

	private static final String MENSAJE_ERROR_DESCONOCIDO = "Ocurrio un error desconocido en el servidor";

	@ExceptionHandler(value = ReporteVehiculosException.class)
	public ResponseEntity<Object> exceptionPropia(ReporteVehiculosException reporteVehiculosException) {
		return new ResponseEntity<>(reporteVehiculosException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<Object> exceptionOtra(RuntimeException exception) {
		return new ResponseEntity<>(MENSAJE_ERROR_DESCONOCIDO, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
