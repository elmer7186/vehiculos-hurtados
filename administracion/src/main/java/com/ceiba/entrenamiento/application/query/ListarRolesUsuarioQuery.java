package com.ceiba.entrenamiento.application.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.entrenamiento.domain.entity.RolUsuario;
import com.ceiba.entrenamiento.domain.entity.Usuario;
import com.ceiba.entrenamiento.domain.port.RolUsuarioRepository;
import com.ceiba.entrenamiento.domain.port.UsuarioRepository;

@Service
public class ListarRolesUsuarioQuery {

	private RolUsuarioRepository rolUsuarioRepository;
	private UsuarioRepository usuarioRepository;

	@Autowired
	public ListarRolesUsuarioQuery(RolUsuarioRepository rolUsuarioRepository, UsuarioRepository usuarioRepository) {
		super();
		this.rolUsuarioRepository = rolUsuarioRepository;
		this.usuarioRepository = usuarioRepository;
	}

	public List<RolUsuario> execute(String usuario) {
		Usuario objUsuario = usuarioRepository.findByNombre(usuario);
		return rolUsuarioRepository.findByUsuario(objUsuario);
	}

}
