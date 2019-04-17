package com.ceiba.entrenamiento.application.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.entrenamiento.application.dto.RolUsuarioDto;
import com.ceiba.entrenamiento.domain.entity.Rol;
import com.ceiba.entrenamiento.domain.entity.RolUsuario;
import com.ceiba.entrenamiento.domain.entity.Usuario;
import com.ceiba.entrenamiento.domain.port.RolRepository;
import com.ceiba.entrenamiento.domain.port.RolUsuarioRepository;
import com.ceiba.entrenamiento.domain.port.UsuarioRepository;

@Service
public class AsociarRolesUsuarioCommand {

	private UsuarioRepository usuarioRepository;
	private RolRepository rolRepository;
	private RolUsuarioRepository rolUsuarioRepository;

	@Autowired
	public AsociarRolesUsuarioCommand(UsuarioRepository usuarioRepository, RolRepository rolRepository,
			RolUsuarioRepository rolUsuarioRepository) {
		this.usuarioRepository = usuarioRepository;
		this.rolRepository = rolRepository;
		this.rolUsuarioRepository = rolUsuarioRepository;
	}

	public void execute(RolUsuarioDto rolUsuarioDto) {
		Usuario usuario = usuarioRepository.findByNombre(rolUsuarioDto.getUsuario());
		List<Rol> roles = new ArrayList<>();
		rolUsuarioDto.getRoles().forEach(rolString -> roles.add(rolRepository.findByNombre(rolString)));
		roles.forEach(rol -> {
			RolUsuario rolUsuario = new RolUsuario(0, usuario, rol);
			rolUsuarioRepository.save(rolUsuario);
		});
	}

}
