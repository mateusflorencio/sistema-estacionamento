package com.florencio.estacionamento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florencio.estacionamento.domain.Atendente;
import com.florencio.estacionamento.repositories.AtendenteRepository;

@Service
public class AtendenteService {
	
	@Autowired
	private AtendenteRepository repo;
	
	public Atendente findById(Integer id) {
		Optional<Atendente> obj = repo.findById(id);
		return obj.orElseThrow(()-> new IllegalArgumentException("Id não encontrado"));
	}

}
