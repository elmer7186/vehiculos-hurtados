package com.ceiba.entrenamiento.aplication.integration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.entrenamiento.aplication.builder.CiudadDtoBuilderTest;
import com.ceiba.entrenamiento.aplication.builder.PaisDtoBuilderTest;
import com.ceiba.entrenamiento.application.command.CrearEditarCiudadCommand;
import com.ceiba.entrenamiento.application.command.CrearEditarPaisCommand;
import com.ceiba.entrenamiento.application.dto.CiudadDto;
import com.ceiba.entrenamiento.application.dto.PaisDto;
import com.ceiba.entrenamiento.domain.entity.Ciudad;
import com.ceiba.entrenamiento.domain.port.CiudadRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearEditarCiudadCommandIntegrationTest {

	private static final String CODIGO_CIUDAD = "CAL";
	private static final String NOMBRE_CIUDAD = "Cali";
	private static final String CODIGO_PAIS = "COL";
	private static final String NOMBRE_PAIS = "Colombia";

	@Autowired
	private CrearEditarCiudadCommand crearEditarCiudadCommand;

	@Autowired
	private CrearEditarPaisCommand crearEditarPaisCommand;

	@Autowired
	private CiudadRepository ciudadRepository;

	@Test
	public void crearCiudadConPaisExistenteTest() {
		// arrange
		CiudadDto ciudadDto = CiudadDtoBuilderTest.defaultValues().withCodigo(CODIGO_CIUDAD).withNombre(NOMBRE_CIUDAD)
				.withCodigoPais(CODIGO_PAIS).build();

		PaisDto paisDto = PaisDtoBuilderTest.defaultValues().withCodigo(CODIGO_PAIS).withNombre(NOMBRE_PAIS).build();

		// act
		crearEditarPaisCommand.execute(paisDto);
		crearEditarCiudadCommand.execute(ciudadDto);
		Ciudad ciudadConsulta = ciudadRepository.findByCodigo(CODIGO_CIUDAD);

		// assert
		Assert.assertEquals(CODIGO_CIUDAD, ciudadConsulta.getCodigo());
		Assert.assertEquals(NOMBRE_CIUDAD, ciudadConsulta.getNombre());

	}
}
