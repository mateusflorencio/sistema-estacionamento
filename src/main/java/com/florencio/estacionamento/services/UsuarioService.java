package com.florencio.estacionamento.services;

import java.util.List;
import java.util.Optional;

import com.florencio.estacionamento.domain.Usuario;
import com.florencio.estacionamento.dto.UsuarioNewDTO;
import com.florencio.estacionamento.repositories.UsuarioRepository;
import com.florencio.estacionamento.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;

	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + UsuarioService.class.getName()));
	}

	@Transactional
	public Usuario insert(Usuario entity) {
		entity.setId(null);
		entity = repo.save(entity);
		return entity;
	}

	public List<Usuario> findAll() {
		return repo.findAll();
	}

	public Usuario fromDTO(UsuarioNewDTO entityDto) {
		Usuario entity = new Usuario(null, entityDto.getNome());
		entity.getTelefone().add(entityDto.getTelefone1());
		if (entityDto.getTelefone2() != null) {
			entity.getTelefone().add(entityDto.getTelefone2());
		}
		return entity;

	}

	public Usuario update(Usuario obj) {
		Usuario usuario = findById(obj.getId());
		usuario.setNome(obj.getNome());
		usuario.setTelefone(obj.getTelefone());

		return repo.save(usuario);
	}
}
