package com.ceiba.entrenamiento.aplication.integration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.entrenamiento.aplication.builder.PaisDtoBuilderTest;
import com.ceiba.entrenamiento.application.command.CrearEditarPaisCommand;
import com.ceiba.entrenamiento.application.dto.PaisDto;
import com.ceiba.entrenamiento.domain.entity.Pais;
import com.ceiba.entrenamiento.domain.port.PaisRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearEditarPaisCommandIntegrationTest {

	private static final String CODIGO_PAIS = "CAN";
	private static final String NOMBRE_PAIS = "Canada";

	@Autowired
	private CrearEditarPaisCommand crearEditarPaisCommand;

	@Autowired
	private PaisRepository paisRepository;

	@Test
	public void crearPaisTest() {
		// arrange
		PaisDto paisDto = PaisDtoBuilderTest.defaultValues().withCodigo(CODIGO_PAIS).withNombre(NOMBRE_PAIS).build();

		// act
		crearEditarPaisCommand.execute(paisDto);
		Pais paisConsulta = paisRepository.findByCodigo(CODIGO_PAIS);

		// assert
		Assert.assertEquals(CODIGO_PAIS, paisConsulta.getCodigo());
		Assert.assertEquals(NOMBRE_PAIS, paisConsulta.getNombre());

	}
}
