package com.ceiba.entrenamiento.aplication.unit;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.entrenamiento.aplication.builder.AvistamientoDtoBuilderTest;
import com.ceiba.entrenamiento.application.command.RegistrarAvistamientoVehiculoCommand;
import com.ceiba.entrenamiento.application.dto.AvistamientoDto;
import com.ceiba.entrenamiento.domain.VehiculoService;
import com.ceiba.entrenamiento.domain.entity.Dispositivo;
import com.ceiba.entrenamiento.domain.entity.Reporte;
import com.ceiba.entrenamiento.domain.entity.Vehiculo;
import com.ceiba.entrenamiento.domain.exception.ReporteVehiculosException;
import com.ceiba.entrenamiento.domain.port.DispositivoRepository;
import com.ceiba.entrenamiento.domain.port.ReporteRepository;
import com.ceiba.entrenamiento.domain.port.VehiculoRepository;
import com.ceiba.entrenamiento.domini.builder.DispositivoBuilderTest;
import com.ceiba.entrenamiento.domini.builder.VehiculoBuilderTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrarAvistamientoVehiculoCommandUnitTest {

	private static final String PLACA_VEHICULO = "ALQ179";
	private static final String IMEI_DISPOSITIVO = "1987252771";
	private static final String FOTO_AVISTAMIENTO = "foto_prueba.jpg";
	private static final String FECHA_AVISTAMIENTO = "24/02/2019 10:30";
	private static final String MENSAJE_SE_ESPERABA_EXCEPCION = "Se esperaba excepción y esta no fue lanzada";

	private SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	@Autowired
	private RegistrarAvistamientoVehiculoCommand registrarAvistamientoVehiculoCommand;

	@MockBean
	private ReporteRepository reporteRepository;

	@SpyBean
	private VehiculoService vehiculoService;

	@MockBean
	private VehiculoRepository vehiculoRepository;

	@MockBean
	private DispositivoRepository dispositivoRepository;

	@Test
	public void registrarAvistamientoVehiculoExistenteTest() throws ParseException {
		// arrange
		AvistamientoDto avistamientoDto = AvistamientoDtoBuilderTest.defaultValues().withPlaca(PLACA_VEHICULO)
				.withImei(IMEI_DISPOSITIVO).withFoto(FOTO_AVISTAMIENTO)
				.withFecha(formatoFechaHora.parse(FECHA_AVISTAMIENTO)).build();
		Vehiculo vehiculo = VehiculoBuilderTest.defaultValues().withPlaca(PLACA_VEHICULO).build();
		Dispositivo dispositivo = DispositivoBuilderTest.defaultValues().withImei(IMEI_DISPOSITIVO).build();
		Mockito.when(vehiculoRepository.findByPlaca(PLACA_VEHICULO)).thenReturn(vehiculo);
		Mockito.when(dispositivoRepository.findByImei(IMEI_DISPOSITIVO)).thenReturn(dispositivo);

		// act
		registrarAvistamientoVehiculoCommand.execute(avistamientoDto);

		// assert

	}

	@Test
	public void registrarAvistamientoVehiculoNoExistenteTest() throws ParseException {
		// arrange
		AvistamientoDto avistamientoDto = AvistamientoDtoBuilderTest.defaultValues().withPlaca(PLACA_VEHICULO)
				.withImei(IMEI_DISPOSITIVO).withFoto(FOTO_AVISTAMIENTO)
				.withFecha(formatoFechaHora.parse(FECHA_AVISTAMIENTO)).build();
		Vehiculo vehiculo = VehiculoBuilderTest.defaultValues().withPlaca(PLACA_VEHICULO).build();
		Dispositivo dispositivo = DispositivoBuilderTest.defaultValues().withImei(IMEI_DISPOSITIVO).build();
		Mockito.when(vehiculoRepository.findByPlaca(PLACA_VEHICULO)).thenReturn(null);
		Mockito.when(dispositivoRepository.findByImei(IMEI_DISPOSITIVO)).thenReturn(dispositivo);
		Mockito.when(vehiculoRepository.save(Mockito.any())).thenReturn(vehiculo);

		// act
		registrarAvistamientoVehiculoCommand.execute(avistamientoDto);

		// assert
	}

	@Test
	public void registrarAvistamientoDispositivoNoExistenteFailTest() throws ParseException {
		// arrange
		AvistamientoDto avistamientoDto = AvistamientoDtoBuilderTest.defaultValues().withPlaca(PLACA_VEHICULO)
				.withImei(IMEI_DISPOSITIVO).withFoto(FOTO_AVISTAMIENTO)
				.withFecha(formatoFechaHora.parse(FECHA_AVISTAMIENTO)).build();
		Mockito.when(vehiculoRepository.findByPlaca(PLACA_VEHICULO)).thenReturn(null);
		Mockito.when(dispositivoRepository.findByImei(IMEI_DISPOSITIVO)).thenReturn(null);

		try {
			// act
			registrarAvistamientoVehiculoCommand.execute(avistamientoDto);
			fail(MENSAJE_SE_ESPERABA_EXCEPCION);
		} catch (ReporteVehiculosException e) {
			// assert
			Assert.assertEquals(Reporte.MENSAJE_DISPOSITIVO_REQUERIDO, e.getMessage());
		}
	}

	@Test
	public void registrarAvistamientoVehiculoSinPlacaFailTest() throws ParseException {
		// arrange
		AvistamientoDto avistamientoDto = AvistamientoDtoBuilderTest.defaultValues().withImei(IMEI_DISPOSITIVO)
				.withFoto(FOTO_AVISTAMIENTO).withFecha(formatoFechaHora.parse(FECHA_AVISTAMIENTO)).build();
		Mockito.when(vehiculoRepository.findByPlaca(Mockito.any())).thenReturn(null);

		try {
			// act
			registrarAvistamientoVehiculoCommand.execute(avistamientoDto);
			fail(MENSAJE_SE_ESPERABA_EXCEPCION);
		} catch (ReporteVehiculosException e) {
			// assert
			Assert.assertEquals(Vehiculo.MENSAJE_PLACA_REQUERIDA, e.getMessage());
		}
	}

}
