package com.ceiba.entrenamiento.aplication.integration;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.entrenamiento.aplication.builder.HurtoDtoBuilderTest;
import com.ceiba.entrenamiento.application.command.RegistrarDenunciaDeHurtoCommand;
import com.ceiba.entrenamiento.application.dto.HurtoDto;
import com.ceiba.entrenamiento.domain.CiudadService;
import com.ceiba.entrenamiento.domain.PaisService;
import com.ceiba.entrenamiento.domain.entity.Ciudad;
import com.ceiba.entrenamiento.domain.entity.Hurto;
import com.ceiba.entrenamiento.domain.entity.Pais;
import com.ceiba.entrenamiento.domain.entity.Vehiculo;
import com.ceiba.entrenamiento.domain.port.HurtoRepository;
import com.ceiba.entrenamiento.domini.builder.CiudadBuilderTest;
import com.ceiba.entrenamiento.domini.builder.PaisBuilderTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrarDenunciaDeHurtoCommandIntegrationTest {

	private static final String PLACA_VEHICULO = "HJK178";
	private static final String TIPO_VEHICULO = "MOTO";
	private static final String COLOR_VEHICULO = "GRIS";
	private static final String MODELO_VEHICULO = "2017";
	private static final String MARCA_VEHICULO = "Renault";
	private static final String FECHA_HURTO = "16/04/2017 22:30";
	private static final String DESCRIPCION_HURTO = "El vehiculo se encontraba parqueado y desapareció del lugar";
	private static final String CODIGO_CIUDAD = "MED";
	private static final String NOMBRE_CIUDAD = "Medellin";
	private static final String CODIGO_PAIS = "COL";
	private static final String NOMBRE_PAIS = "Colombia";

	private SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	@Autowired
	private RegistrarDenunciaDeHurtoCommand registrarDenunciaDeHurtoCommand;

	@Autowired
	private HurtoRepository hurtoRepository;

	@Autowired
	private CiudadService ciudadService;

	@Autowired
	private PaisService paisService;

	@Test
	public void registrarHurtoTest() throws ParseException {
		// arrange
		HurtoDto hurtoDto = HurtoDtoBuilderTest.defaultValues().withPlaca(PLACA_VEHICULO).withTipo(TIPO_VEHICULO)
				.withColor(COLOR_VEHICULO).withModelo(MODELO_VEHICULO).withMarca(MARCA_VEHICULO)
				.withFechaHurto(formatoFechaHora.parse(FECHA_HURTO)).withDescripcion(DESCRIPCION_HURTO)
				.withCodigoCiudad(CODIGO_CIUDAD).build();
		Pais pais = PaisBuilderTest.defaultValues().withCodigo(CODIGO_PAIS).withNombre(NOMBRE_PAIS).build();
		Ciudad ciudad = CiudadBuilderTest.defaultValues().withCodigo(CODIGO_CIUDAD).withNombre(NOMBRE_CIUDAD)
				.withPais(pais).build();

		// act
		paisService.almacenarPais(pais);
		ciudadService.almacenarCiudad(ciudad);
		Hurto hurtoAlmacenado = registrarDenunciaDeHurtoCommand.execute(hurtoDto);
		Hurto hurtoConsulta = hurtoRepository.findById(hurtoAlmacenado.getId());
		Vehiculo vehiculoConsulta = hurtoConsulta.getVehiculo();

		// assert
		Assert.assertEquals(PLACA_VEHICULO, vehiculoConsulta.getPlaca());
		Assert.assertEquals(TIPO_VEHICULO, vehiculoConsulta.getTipo());
		Assert.assertEquals(COLOR_VEHICULO, vehiculoConsulta.getColor());
		Assert.assertEquals(MODELO_VEHICULO, vehiculoConsulta.getModelo());
		Assert.assertEquals(MARCA_VEHICULO, vehiculoConsulta.getMarca());
		Assert.assertEquals(FECHA_HURTO, formatoFechaHora.format(hurtoConsulta.getFechaHurto()));
		Assert.assertEquals(DESCRIPCION_HURTO, hurtoConsulta.getDescripcion());
		Assert.assertEquals(CODIGO_CIUDAD, hurtoConsulta.getCiudad().getCodigo());
	}

}
