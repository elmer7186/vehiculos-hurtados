package com.ceiba.entrenamiento.application.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.entrenamiento.application.command.CrearRolCommand;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearRolCommandUnitTest {

	@Autowired
	private CrearRolCommand crearRolCommand;
	
	@Test
	public void nombreRolNuloFailTest() {
		
	}
	
}