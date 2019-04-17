package com.ceiba.entrenamiento.aplication.integration;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.entrenamiento.aplication.builder.AvistamientoDtoBuilderTest;
import com.ceiba.entrenamiento.application.command.RegistrarAvistamientoVehiculoCommand;
import com.ceiba.entrenamiento.application.dto.AvistamientoDto;
import com.ceiba.entrenamiento.domain.DispositivoService;
import com.ceiba.entrenamiento.domain.VehiculoService;
import com.ceiba.entrenamiento.domain.entity.Dispositivo;
import com.ceiba.entrenamiento.domain.entity.Vehiculo;
import com.ceiba.entrenamiento.domain.port.VehiculoRepository;
import com.ceiba.entrenamiento.domini.builder.DispositivoBuilderTest;
import com.ceiba.entrenamiento.domini.builder.VehiculoBuilderTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrarAvistamientoVehiculoCommandIntegrationTest {

	private static final String PLACA_VEHICULO = "AFG02A";
	private static final String COLOR_VEHICULO = "Rojo";
	private static final String MARCA_VEHICULO = "Auteco";
	private static final String MODELO_VEHICULO = "2014";
	private static final String TIPO_VEHICULO = "MOTO";
	private static final String IMEI_DISPOSITIVO = "1987252771";
	private static final String FOTO_AVISTAMIENTO = "foto_prueba.jpg";
	private static final String FECHA_AVISTAMIENTO = "24/02/2019 10:30";

	private SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	@Autowired
	private RegistrarAvistamientoVehiculoCommand registrarAvistamientoVehiculoCommand;

	@Autowired
	private VehiculoRepository vehiculoRepository;

	@Autowired
	private VehiculoService vehiculoService;

	@Autowired
	private DispositivoService dispositivoService;

	@Test
	public void registrarVehiculoExistenteNoAlteraDatosVehiculoTest() throws ParseException {
		// arrange
		AvistamientoDto avistamientoDto = AvistamientoDtoBuilderTest.defaultValues().withPlaca(PLACA_VEHICULO)
				.withImei(IMEI_DISPOSITIVO).withFoto(FOTO_AVISTAMIENTO)
				.withFecha(formatoFechaHora.parse(FECHA_AVISTAMIENTO)).build();
		Dispositivo dispositivo = DispositivoBuilderTest.defaultValues().withImei(IMEI_DISPOSITIVO).build();
		dispositivoService.guardarDispositivo(dispositivo);
		// act
		Vehiculo vehiculo = VehiculoBuilderTest.defaultValues().withColor(COLOR_VEHICULO).withPlaca(PLACA_VEHICULO)
				.withMarca(MARCA_VEHICULO).withModelo(MODELO_VEHICULO).withTipo(TIPO_VEHICULO).build();
		vehiculoService.almacenarVehiculo(vehiculo);
		registrarAvistamientoVehiculoCommand.execute(avistamientoDto);
		Vehiculo vehiculoAlmacenado = vehiculoRepository.findByPlaca(PLACA_VEHICULO);

		// assert
		Assert.assertEquals(COLOR_VEHICULO, vehiculoAlmacenado.getColor());
		Assert.assertEquals(MARCA_VEHICULO, vehiculoAlmacenado.getMarca());
		Assert.assertEquals(MODELO_VEHICULO, vehiculoAlmacenado.getModelo());
		Assert.assertEquals(TIPO_VEHICULO, vehiculoAlmacenado.getTipo());
	}

	@Test
	public void registrarAvistamientoVerificarCorrectoAlmacenadoTest() throws ParseException {
		AvistamientoDto avistamientoDto = AvistamientoDtoBuilderTest.defaultValues().withPlaca(PLACA_VEHICULO)
				.withImei(IMEI_DISPOSITIVO).withFoto(FOTO_AVISTAMIENTO)
				.withFecha(formatoFechaHora.parse(FECHA_AVISTAMIENTO)).build();
		Dispositivo dispositivo = DispositivoBuilderTest.defaultValues().withImei(IMEI_DISPOSITIVO).build();
		dispositivoService.guardarDispositivo(dispositivo);
		// act
		registrarAvistamientoVehiculoCommand.execute(avistamientoDto);
		Vehiculo vehiculoNuevo = vehiculoRepository.findByPlaca(PLACA_VEHICULO);

		//TODO ajustar asserts con datos de avistamiento
		// assert
		Assert.assertEquals(COLOR_VEHICULO, vehiculoNuevo.getColor());
		Assert.assertEquals(MARCA_VEHICULO, vehiculoNuevo.getMarca());
		Assert.assertEquals(MODELO_VEHICULO, vehiculoNuevo.getModelo());
		Assert.assertEquals(TIPO_VEHICULO, vehiculoNuevo.getTipo());
	}

}
