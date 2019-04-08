package com.ceiba.entrenamiento.aplication.unit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.entrenamiento.aplication.builder.PaisDtoBuilderTest;
import com.ceiba.entrenamiento.application.command.CrearEditarPaisCommand;
import com.ceiba.entrenamiento.application.dto.PaisDto;
import com.ceiba.entrenamiento.domain.entity.Pais;
import com.ceiba.entrenamiento.domain.exception.ReporteVehiculosException;
import com.ceiba.entrenamiento.domain.port.PaisRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearEditarPaisCommandUnitTest {

	private static final String CODIGO_PAIS = "ECU";
	private static final String NOMBRE_PAIS = "Ecuador";
	private static final String MENSAJE_SE_ESPERABA_EXCEPCION = "Se esperaba excepción y esta no fue lanzada";

	@Autowired
	private CrearEditarPaisCommand crearEditarPaisCommand;

	@MockBean
	private PaisRepository paisRepository;

	@Test
	public void codigoPaisRequeridoFailTest() {
		// arrange
		PaisDto paisDto = PaisDtoBuilderTest.defaultValues().withNombre(NOMBRE_PAIS).build();

		// act
		try {
			crearEditarPaisCommand.execute(paisDto);
			Assert.fail(MENSAJE_SE_ESPERABA_EXCEPCION);
		} catch (ReporteVehiculosException e) {
			// assert
			Assert.assertEquals(Pais.MENSAJE_CODIGO_PAIS_REQUERIDO, e.getMessage());
		}
	}

	@Test
	public void nombrePaisRequeridoFailTest() {
		// arrange
		PaisDto paisDto = PaisDtoBuilderTest.defaultValues().withCodigo(CODIGO_PAIS).build();

		// act
		try {
			crearEditarPaisCommand.execute(paisDto);
			Assert.fail(MENSAJE_SE_ESPERABA_EXCEPCION);
		} catch (ReporteVehiculosException e) {
			// assert
			Assert.assertEquals(Pais.MENSAJE_NOMBRE_PAIS_REQUERIDO, e.getMessage());
		}
	}

	@Test
	public void crearPaisExistenteTest() {
		// arrange
		PaisDto paisDto = PaisDtoBuilderTest.defaultValues().withCodigo(CODIGO_PAIS).withNombre(NOMBRE_PAIS).build();
		Pais pais = new Pais(null, CODIGO_PAIS, NOMBRE_PAIS);
		Mockito.when(paisRepository.findByCodigo(CODIGO_PAIS)).thenReturn(pais);

		// act
		crearEditarPaisCommand.execute(paisDto);
	}

	@Test
	public void crearPaisNoExistenteTest() {
		// arrange
		PaisDto paisDto = PaisDtoBuilderTest.defaultValues().withCodigo(CODIGO_PAIS).withNombre(NOMBRE_PAIS).build();
		Mockito.when(paisRepository.findByCodigo(CODIGO_PAIS)).thenReturn(null);

		// act
		crearEditarPaisCommand.execute(paisDto);
	}

}
