package com.ceiba.entrenamiento.application.integration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.entrenamiento.application.builder.RolUsuarioDtoTestBuilder;
import com.ceiba.entrenamiento.application.dto.RolUsuarioDto;
import com.ceiba.entrenamiento.application.query.ListarRolesUsuarioQuery;
import com.ceiba.entrenamiento.domain.builder.RolTestBuilder;
import com.ceiba.entrenamiento.domain.builder.RolUsuarioTestBuilder;
import com.ceiba.entrenamiento.domain.builder.UsuarioTestBuilder;
import com.ceiba.entrenamiento.domain.entity.Rol;
import com.ceiba.entrenamiento.domain.entity.RolUsuario;
import com.ceiba.entrenamiento.domain.entity.Usuario;
import com.ceiba.entrenamiento.domain.port.RolRepository;
import com.ceiba.entrenamiento.domain.port.RolUsuarioRepository;
import com.ceiba.entrenamiento.domain.port.UsuarioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class RolUsuarioIntegrationTest {

	private static final String NOMBRE_ROL_1 = "Rol 1";
	private static final String NOMBRE_ROL_2 = "Rol 2";
	private static final int NUMERO_ROLES_USUARIO = 2;
	private static final String NOMBRE_USUARIO = "dev.test";
	private static final String CLAVE_USUARIO = "password";
	private static final String EMAIL_USUARIO = "developer@prueba.com";

	private static final String URL_ROLES_USUARIO = "/rolesUsuario";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ListarRolesUsuarioQuery listarRolesUsuarioQuery;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private RolRepository rolRepository;

	@Autowired
	private RolUsuarioRepository rolUsuarioRepository;

	@Test
	public void asociar1RolConUsuarioTest() throws Exception {
		// arrage
		Usuario usuario = UsuarioTestBuilder.defaultValues().withNombre(NOMBRE_USUARIO).withClave(CLAVE_USUARIO)
				.withEmail(EMAIL_USUARIO).withHabilitado(Boolean.TRUE).build();
		usuarioRepository.save(usuario);
		Rol rol = RolTestBuilder.defaultValues().withNombre(NOMBRE_ROL_1).build();
		rolRepository.save(rol);
		RolUsuarioDto rolUsuarioDto = RolUsuarioDtoTestBuilder.defaultValues().withUsuario(NOMBRE_USUARIO)
				.withRol(NOMBRE_ROL_1).build();

		// act
		mockMvc.perform(post(URL_ROLES_USUARIO).contentType(MediaType.APPLICATION_JSON).content(toJson(rolUsuarioDto)))
				.andExpect(status().isOk());
		List<RolUsuario> rolUsuario = listarRolesUsuarioQuery.execute(NOMBRE_USUARIO);

		// assert
		Assert.assertEquals(NOMBRE_USUARIO, rolUsuario.get(0).getUsuario().getNombre());
		Assert.assertEquals(NOMBRE_ROL_1, rolUsuario.get(0).getRol().getNombre());
	}

	@Test
	public void asociar2RolesConUsuarioTest() throws Exception {
		// arrage
		Usuario usuario = UsuarioTestBuilder.defaultValues().withNombre(NOMBRE_USUARIO).withClave(CLAVE_USUARIO)
				.withEmail(EMAIL_USUARIO).withHabilitado(Boolean.TRUE).build();
		usuarioRepository.save(usuario);
		Rol rol1 = RolTestBuilder.defaultValues().withNombre(NOMBRE_ROL_1).build();
		rolRepository.save(rol1);
		Rol rol2 = RolTestBuilder.defaultValues().withNombre(NOMBRE_ROL_2).build();
		rolRepository.save(rol2);
		RolUsuarioDto rolUsuarioDto = RolUsuarioDtoTestBuilder.defaultValues().withUsuario(NOMBRE_USUARIO)
				.withRol(NOMBRE_ROL_1).withRol(NOMBRE_ROL_2).build();

		// act
		mockMvc.perform(post(URL_ROLES_USUARIO).contentType(MediaType.APPLICATION_JSON).content(toJson(rolUsuarioDto)))
				.andExpect(status().isOk());
		List<RolUsuario> rolUsuario = listarRolesUsuarioQuery.execute(NOMBRE_USUARIO);

		// assert
		Assert.assertEquals(NUMERO_ROLES_USUARIO, rolUsuario.size());
	}

	@Test
	public void asociar2RolesUsuarioListar2Test() throws Exception {
		// arrage
		Usuario usuario = UsuarioTestBuilder.defaultValues().withNombre(NOMBRE_USUARIO).withClave(CLAVE_USUARIO)
				.withEmail(EMAIL_USUARIO).withHabilitado(Boolean.TRUE).build();
		usuarioRepository.save(usuario);
		Rol rol1 = RolTestBuilder.defaultValues().withNombre(NOMBRE_ROL_1).build();
		rolRepository.save(rol1);
		Rol rol2 = RolTestBuilder.defaultValues().withNombre(NOMBRE_ROL_2).build();
		rolRepository.save(rol2);
		RolUsuario rolUsuario1 = RolUsuarioTestBuilder.defaultValues().withRol(rol1).withUsuario(usuario).build();
		RolUsuario rolUsuario2 = RolUsuarioTestBuilder.defaultValues().withRol(rol2).withUsuario(usuario).build();
		rolUsuarioRepository.save(rolUsuario1);
		rolUsuarioRepository.save(rolUsuario2);
		
		// act
		mockMvc.perform(get(URL_ROLES_USUARIO).param("usuario", NOMBRE_USUARIO)).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.hasSize(2)));
	}

	@Test
	public void asociar1RolUsuarioListarContenidoTest() throws Exception {
		// arrage
		Usuario usuario = UsuarioTestBuilder.defaultValues().withNombre(NOMBRE_USUARIO).withClave(CLAVE_USUARIO)
				.withEmail(EMAIL_USUARIO).withHabilitado(Boolean.TRUE).build();
		usuarioRepository.save(usuario);
		Rol rol = RolTestBuilder.defaultValues().withNombre(NOMBRE_ROL_1).build();
		rolRepository.save(rol);
		RolUsuario rolUsuario = RolUsuarioTestBuilder.defaultValues().withRol(rol).withUsuario(usuario).build();
		rolUsuarioRepository.save(rolUsuario);
		
		// act
		mockMvc.perform(get(URL_ROLES_USUARIO).param("usuario", NOMBRE_USUARIO)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].usuario.nombre", equalTo(NOMBRE_USUARIO)))
				.andExpect(jsonPath("$[0].rol.nombre", equalTo(NOMBRE_ROL_1)));
	}

	public String toJson(final Object obj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}

}
