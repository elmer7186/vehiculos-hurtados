package com.ceiba.entrenamiento.application.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.entrenamiento.application.command.CrearUsuarioCommand;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearUsuarioCommandUnitTest {

	@Autowired
	private CrearUsuarioCommand crearUsuarioCommand;
	
	@Test
	public void nombreUsuarioExistenteFailTest() {
		
	}
	
	@Test
	public void nombreUsuarioNuloFailTest() {
		
	}
	
	@Test
	public void claveUsuarioNulaFailTest() {
		
	}
		
	@Test
	public void emailNuloFailTest() {
		
	}
	
	@Test
	public void emailNoTieneEstructuraEmailFailTest() {
		
	}
	
}
