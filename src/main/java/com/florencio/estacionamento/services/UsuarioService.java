package com.florencio.estacionamento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florencio.estacionamento.domain.Usuario;
import com.florencio.estacionamento.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(()-> new IllegalArgumentException("Id não encontrado"));
	}

}
