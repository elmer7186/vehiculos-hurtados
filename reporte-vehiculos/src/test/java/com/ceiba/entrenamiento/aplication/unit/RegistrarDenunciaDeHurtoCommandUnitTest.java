package com.ceiba.entrenamiento.aplication.unit;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.entrenamiento.aplication.builder.HurtoDtoBuilderTest;
import com.ceiba.entrenamiento.application.command.RegistrarDenunciaDeHurtoCommand;
import com.ceiba.entrenamiento.application.dto.HurtoDto;
import com.ceiba.entrenamiento.domain.VehiculoService;
import com.ceiba.entrenamiento.domain.entity.Ciudad;
import com.ceiba.entrenamiento.domain.entity.Hurto;
import com.ceiba.entrenamiento.domain.entity.Pais;
import com.ceiba.entrenamiento.domain.entity.Vehiculo;
import com.ceiba.entrenamiento.domain.exception.ReporteVehiculosException;
import com.ceiba.entrenamiento.domain.port.CiudadRepository;
import com.ceiba.entrenamiento.domini.builder.CiudadBuilderTest;
import com.ceiba.entrenamiento.domini.builder.PaisBuilderTest;
import com.ceiba.entrenamiento.domini.builder.VehiculoBuilderTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrarDenunciaDeHurtoCommandUnitTest {

	private static final String PLACA_VEHICULO = "HJK178";
	private static final String FECHA_HURTO = "16/04/2017 22:30";
	private static final String CODIGO_CIUDAD = "MED";
	private static final String NOMBRE_CIUDAD = "Medellin";
	private static final String CODIGO_PAIS = "COL";
	private static final String NOMBRE_PAIS = "Colombia";
	private static final String MENSAJE_SE_ESPERABA_EXCEPCION = "Se esperaba excepción y esta no fue lanzada";

	private SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	@Autowired
	private RegistrarDenunciaDeHurtoCommand registrarDenunciaDeHurtoCommand;

	@MockBean
	private VehiculoService vehiculoService;

	@MockBean
	private CiudadRepository ciudadRepository;

	@Test
	public void codigoCiudadRequeridoFailTest() throws ParseException {
		// arrange
		HurtoDto hurtoDto = HurtoDtoBuilderTest.defaultValues().withPlaca(PLACA_VEHICULO)
				.withFechaHurto(formatoFechaHora.parse(FECHA_HURTO)).build();
		Vehiculo vehiculo = VehiculoBuilderTest.defaultValues().withPlaca(PLACA_VEHICULO).build();
		Mockito.when(vehiculoService.almacenarVehiculo(Mockito.any(Vehiculo.class))).thenReturn(vehiculo);
		Mockito.when(ciudadRepository.findByCodigo(Mockito.anyString())).thenReturn(null);
		// act
		try {
			registrarDenunciaDeHurtoCommand.execute(hurtoDto);
			Assert.fail(MENSAJE_SE_ESPERABA_EXCEPCION);
		} catch (ReporteVehiculosException e) {
			// assert
			Assert.assertEquals(Hurto.MENSAJE_CIUDAD_REQUERIDA, e.getMessage());
		}
	}

	@Test
	public void placaVehiculoRequeridaFailTest() throws ParseException {
		// arrange
		HurtoDto hurtoDto = HurtoDtoBuilderTest.defaultValues().withCodigoCiudad(CODIGO_CIUDAD)
				.withFechaHurto(formatoFechaHora.parse(FECHA_HURTO)).build();
		// act
		try {
			registrarDenunciaDeHurtoCommand.execute(hurtoDto);
			Assert.fail(MENSAJE_SE_ESPERABA_EXCEPCION);
		} catch (ReporteVehiculosException e) {
			// assert
			Assert.assertEquals(Vehiculo.MENSAJE_PLACA_REQUERIDA, e.getMessage());
		}
	}

	@Test
	public void fechaHurtoRequeridaFailTest() {
		// arrange
		HurtoDto hurtoDto = HurtoDtoBuilderTest.defaultValues().withPlaca(PLACA_VEHICULO)
				.withCodigoCiudad(CODIGO_CIUDAD).build();
		Pais pais = PaisBuilderTest.defaultValues().withCodigo(CODIGO_PAIS).withNombre(NOMBRE_PAIS).build();
		Ciudad ciudad = CiudadBuilderTest.defaultValues().withCodigo(CODIGO_CIUDAD).withNombre(NOMBRE_CIUDAD)
				.withPais(pais).build();
		Vehiculo vehiculo = VehiculoBuilderTest.defaultValues().withPlaca(PLACA_VEHICULO).build();
		Mockito.when(vehiculoService.almacenarVehiculo(Mockito.any(Vehiculo.class))).thenReturn(vehiculo);
		Mockito.when(ciudadRepository.findByCodigo(CODIGO_CIUDAD)).thenReturn(ciudad);
		// act
		try {
			registrarDenunciaDeHurtoCommand.execute(hurtoDto);
			Assert.fail(MENSAJE_SE_ESPERABA_EXCEPCION);
		} catch (ReporteVehiculosException e) {
			// assert
			Assert.assertEquals(Hurto.MENSAJE_FECHA_HURTO_REQUERIDA, e.getMessage());
		}
	}

}
