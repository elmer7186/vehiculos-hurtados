package com.ceiba.entrenamiento.aplication.unit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.entrenamiento.aplication.builder.LogDispositivoDtoBuilderTest;
import com.ceiba.entrenamiento.application.command.RegistrarLogDispositivoCommand;
import com.ceiba.entrenamiento.application.dto.LogDispositivoDto;
import com.ceiba.entrenamiento.domain.entity.Dispositivo;
import com.ceiba.entrenamiento.domain.entity.LogDispositivo;
import com.ceiba.entrenamiento.domain.port.DispositivoRepository;
import com.ceiba.entrenamiento.domain.port.LogDispositivoRepository;
import com.ceiba.entrenamiento.domini.builder.DispositivoBuilderTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrarLogDispositivoCommandUnitTest {

	private static final String IMEI_DISPOSITIVO = "9674578995";
	private static final String ESTADO_DISPOSITIVO = "FALLO";
	private static final String DETALLE_DISPOSITIVO = "No está registrando capturas";
	private static final String MENSAJE_SE_ESPERABA_EXCEPCION = "Se esperaba excepción y esta no fue lanzada";

	@Autowired
	private RegistrarLogDispositivoCommand registrarLogDispositivoCommand;

	@MockBean
	private DispositivoRepository dispositivoRepository;

	@MockBean
	private LogDispositivoRepository logDispositivoRepository;

	@Test
	public void dispositivoRequeridoFailTest() {
		// arrange
		LogDispositivoDto logDispositivoDto = LogDispositivoDtoBuilderTest.defaultValues()
				.withEstado(ESTADO_DISPOSITIVO).withDetalle(DETALLE_DISPOSITIVO).build();
		Mockito.when(dispositivoRepository.findByImei(null)).thenReturn(null);
		try {
			// act
			registrarLogDispositivoCommand.execute(logDispositivoDto);
			Assert.fail(MENSAJE_SE_ESPERABA_EXCEPCION);
		} catch (Exception e) {
			// assert
			Assert.assertEquals(LogDispositivo.MENSAJE_DISPOSITIVO_REQUERIDO, e.getMessage());
		}
	}

	@Test
	public void estadoRequeridoFailTest() {
		// arrange
		LogDispositivoDto logDispositivoDto = LogDispositivoDtoBuilderTest.defaultValues().withImei(IMEI_DISPOSITIVO)
				.withDetalle(DETALLE_DISPOSITIVO).build();
		Dispositivo dispositivo = DispositivoBuilderTest.defaultValues().withImei(IMEI_DISPOSITIVO).build();
		Mockito.when(dispositivoRepository.findByImei(IMEI_DISPOSITIVO)).thenReturn(dispositivo);
		try {
			// act
			registrarLogDispositivoCommand.execute(logDispositivoDto);
			Assert.fail(MENSAJE_SE_ESPERABA_EXCEPCION);
		} catch (Exception e) {
			// assert
			Assert.assertEquals(LogDispositivo.MENSAJE_ESTADO_REQUERIDO, e.getMessage());
		}
	}

}
