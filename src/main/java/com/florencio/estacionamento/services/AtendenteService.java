package com.florencio.estacionamento.services;

import java.util.List;
import java.util.Optional;

import com.florencio.estacionamento.domain.Atendente;
import com.florencio.estacionamento.repositories.AtendenteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


@Service
public class AtendenteService {
	
	@Autowired
	private AtendenteRepository repo;
	
	public Atendente findById(Integer id) {
		Optional<Atendente> obj = repo.findById(id);
		return obj.orElseThrow(()-> new IllegalArgumentException("Id não encontrado"));
	}

	@GetMapping(value="]")
	public List<Atendente> findAll() {
		return repo.findAll();
	}
	

}
