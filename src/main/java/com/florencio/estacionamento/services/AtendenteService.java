package com.florencio.estacionamento.services;

import java.util.List;
import java.util.Optional;

import com.florencio.estacionamento.domain.Atendente;
import com.florencio.estacionamento.repositories.AtendenteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Service
public class AtendenteService {
	
	@Autowired
	private AtendenteRepository repo;
	
	public Atendente findById(Integer id) {
		Optional<Atendente> obj = repo.findById(id);
		return obj.orElseThrow(()-> new IllegalArgumentException("Id não encontrado"));
	}

	public List<Atendente> findAll() {
		return repo.findAll();
	}

	public Atendente insert (Atendente entity){
		entity.setId(null);
		entity = repo.save(entity);
		return entity;
	}
	
	

}
