package com.ceiba.entrenamiento.application.unit;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.entrenamiento.application.builder.RolUsuarioDtoTestBuilder;
import com.ceiba.entrenamiento.application.command.AsociarRolesUsuarioCommand;
import com.ceiba.entrenamiento.application.dto.RolUsuarioDto;
import com.ceiba.entrenamiento.domain.builder.RolTestBuilder;
import com.ceiba.entrenamiento.domain.builder.UsuarioTestBuilder;
import com.ceiba.entrenamiento.domain.entity.Rol;
import com.ceiba.entrenamiento.domain.entity.RolUsuario;
import com.ceiba.entrenamiento.domain.entity.Usuario;
import com.ceiba.entrenamiento.domain.exception.AdministracionException;
import com.ceiba.entrenamiento.domain.port.RolRepository;
import com.ceiba.entrenamiento.domain.port.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AsociarRolesUsuarioCommandUnitTest {

	private static final String NOMBRE_ROL = "Rol Prueba";
	private static final String NOMBRE_USUARIO = "dev.test";
	private static final String CLAVE_USUARIO = "password";
	private static final String EMAIL_USUARIO = "developer@prueba.com";
	private static final String MENSAJE_SE_ESPERABA_EXCEPCION = "Se esperaba excepción y esta no fue lanzada";

	@Autowired
	private AsociarRolesUsuarioCommand asociarRolesUsuarioCommand;

	@MockBean
	private UsuarioRepository usuarioRepository;

	@MockBean
	private RolRepository rolRepository;

	@Test
	public void rolNuloFailTest() {
		// arrange
		Usuario usuario = UsuarioTestBuilder.defaultValues().withNombre(NOMBRE_USUARIO).withClave(CLAVE_USUARIO)
				.withEmail(EMAIL_USUARIO).withHabilitado(Boolean.TRUE).build();
		RolUsuarioDto rolUsuarioDto = RolUsuarioDtoTestBuilder.defaultValues().withUsuario(NOMBRE_USUARIO)
				.withRol(NOMBRE_ROL).build();
		Mockito.when(usuarioRepository.findByNombre(NOMBRE_USUARIO)).thenReturn(usuario);
		Mockito.when(rolRepository.findByNombre(NOMBRE_ROL)).thenReturn(null);

		try {
			// act
			asociarRolesUsuarioCommand.execute(rolUsuarioDto);
			fail(MENSAJE_SE_ESPERABA_EXCEPCION);
		} catch (AdministracionException e) {
			// assert
			Assert.assertEquals(RolUsuario.MENSAJE_ROL_REQUERIDO, e.getMessage());
		}
	}

	@Test
	public void usuarioNuloFailTest() {
		// arrange
		Rol rol = RolTestBuilder.defaultValues().withNombre(NOMBRE_ROL).build();
		RolUsuarioDto rolUsuarioDto = RolUsuarioDtoTestBuilder.defaultValues().withUsuario(NOMBRE_USUARIO)
				.withRol(NOMBRE_ROL).build();
		Mockito.when(usuarioRepository.findByNombre(NOMBRE_USUARIO)).thenReturn(null);
		Mockito.when(rolRepository.findByNombre(NOMBRE_ROL)).thenReturn(rol);

		try {
			// act
			asociarRolesUsuarioCommand.execute(rolUsuarioDto);
			fail(MENSAJE_SE_ESPERABA_EXCEPCION);
		} catch (AdministracionException e) {
			// assert
			Assert.assertEquals(RolUsuario.MENSAJE_USUARIO_REQUERIDO, e.getMessage());
		}
	}

}
