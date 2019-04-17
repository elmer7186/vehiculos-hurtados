package com.ceiba.entrenamiento.aplication.unit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.entrenamiento.aplication.builder.CiudadDtoBuilderTest;
import com.ceiba.entrenamiento.application.command.CrearEditarCiudadCommand;
import com.ceiba.entrenamiento.application.dto.CiudadDto;
import com.ceiba.entrenamiento.domain.CiudadService;
import com.ceiba.entrenamiento.domain.entity.Ciudad;
import com.ceiba.entrenamiento.domain.entity.Pais;
import com.ceiba.entrenamiento.domain.exception.ReporteVehiculosException;
import com.ceiba.entrenamiento.domain.port.CiudadRepository;
import com.ceiba.entrenamiento.domain.port.PaisRepository;
import com.ceiba.entrenamiento.domini.builder.CiudadBuilderTest;
import com.ceiba.entrenamiento.domini.builder.PaisBuilderTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearEditarCiudadCommandUnitTest {

	private static final String CODIGO_CIUDAD = "CAL";
	private static final String NOMBRE_CIUDAD = "Cali";
	private static final String NOMBRE_CIUDAD_ALTERNO = "Cali La Sucursal";
	private static final String CODIGO_PAIS = "COL";
	private static final String NOMBRE_PAIS = "Colombia";
	private static final String MENSAJE_SE_ESPERABA_EXCEPCION = "Se esperaba excepción y esta no fue lanzada";

	@Autowired
	private CrearEditarCiudadCommand crearEditarCiudadCommand;

	@MockBean
	private PaisRepository paisRepository;

	@SpyBean
	private CiudadService ciudadService;

	@MockBean
	private CiudadRepository ciudadRepository;

	@Test
	public void crearCiudadConPaisNoExistenteFailTest() {
		// arrange
		CiudadDto ciudadDto = CiudadDtoBuilderTest.defaultValues().withCodigo(CODIGO_CIUDAD).withNombre(NOMBRE_CIUDAD)
				.withCodigoPais(CODIGO_PAIS).build();

		Mockito.when(paisRepository.findByCodigo(CODIGO_PAIS)).thenReturn(null);

		// act
		try {
			crearEditarCiudadCommand.execute(ciudadDto);
			Assert.fail(MENSAJE_SE_ESPERABA_EXCEPCION);
		} catch (ReporteVehiculosException e) {
			// assert
			Assert.assertEquals(Ciudad.MENSAJE_PAIS_REQUERIDO, e.getMessage());
		}
	}

	@Test
	public void codigoCiudadRequeridoFailTest() {
		// arrange
		CiudadDto ciudadDto = CiudadDtoBuilderTest.defaultValues().withNombre(NOMBRE_CIUDAD).withCodigoPais(CODIGO_PAIS)
				.build();
		Pais pais = PaisBuilderTest.defaultValues().withCodigo(CODIGO_PAIS).withNombre(NOMBRE_PAIS).build();

		Mockito.when(paisRepository.findByCodigo(CODIGO_PAIS)).thenReturn(pais);

		// act
		try {
			crearEditarCiudadCommand.execute(ciudadDto);
			Assert.fail(MENSAJE_SE_ESPERABA_EXCEPCION);
		} catch (ReporteVehiculosException e) {
			// assert
			Assert.assertEquals(Ciudad.MENSAJE_CODIGO_CIUDAD_REQUERIDO, e.getMessage());
		}
	}

	@Test
	public void nombreCiudadRequeridoFailTest() {
		// arrange
		CiudadDto ciudadDto = CiudadDtoBuilderTest.defaultValues().withCodigo(CODIGO_CIUDAD).withCodigoPais(CODIGO_PAIS)
				.build();
		Pais pais = PaisBuilderTest.defaultValues().withCodigo(CODIGO_PAIS).withNombre(NOMBRE_PAIS).build();
		Mockito.when(paisRepository.findByCodigo(CODIGO_PAIS)).thenReturn(pais);

		// act
		try {
			crearEditarCiudadCommand.execute(ciudadDto);
			Assert.fail(MENSAJE_SE_ESPERABA_EXCEPCION);
		} catch (ReporteVehiculosException e) {
			// assert
			Assert.assertEquals(Ciudad.MENSAJE_NOMBRE_CIUDAD_REQUERIDO, e.getMessage());
		}
	}

	@Test
	public void crearCiudadConPaisExistenteTest() {
		// arrange
		CiudadDto ciudadDto = CiudadDtoBuilderTest.defaultValues().withCodigo(CODIGO_CIUDAD).withNombre(NOMBRE_CIUDAD)
				.withCodigoPais(CODIGO_PAIS).build();

		Pais pais = PaisBuilderTest.defaultValues().withCodigo(CODIGO_PAIS).withNombre(NOMBRE_PAIS).build();

		Mockito.when(paisRepository.findByCodigo(CODIGO_PAIS)).thenReturn(pais);
		Mockito.when(ciudadRepository.findByCodigo(CODIGO_CIUDAD)).thenReturn(null);

		// act
		crearEditarCiudadCommand.execute(ciudadDto);

	}

	@Test
	public void editarCiudadExistenteTest() {
		// arrange
		CiudadDto ciudadDto = CiudadDtoBuilderTest.defaultValues().withCodigo(CODIGO_CIUDAD).withNombre(NOMBRE_CIUDAD)
				.withCodigoPais(CODIGO_PAIS).build();

		Pais pais = PaisBuilderTest.defaultValues().withCodigo(CODIGO_PAIS).withNombre(NOMBRE_PAIS).build();

		Ciudad ciudad = CiudadBuilderTest.defaultValues().withPais(pais).withCodigo(CODIGO_CIUDAD)
				.withNombre(NOMBRE_CIUDAD_ALTERNO).build();

		Mockito.when(paisRepository.findByCodigo(CODIGO_PAIS)).thenReturn(pais);
		Mockito.when(ciudadRepository.findByCodigo(CODIGO_CIUDAD)).thenReturn(ciudad);

		// act
		crearEditarCiudadCommand.execute(ciudadDto);
	}

}
