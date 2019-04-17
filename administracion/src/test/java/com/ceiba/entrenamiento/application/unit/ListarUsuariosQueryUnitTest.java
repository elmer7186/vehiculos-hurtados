package com.ceiba.entrenamiento.application.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.entrenamiento.application.query.ListarUsuariosQuery;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListarUsuariosQueryUnitTest {

	@Autowired
	private ListarUsuariosQuery listarUsuariosQuery;

	@Test
	public void listadoNullTest() {

	}

	@Test
	public void listadoVacioTest() {

	}

}
