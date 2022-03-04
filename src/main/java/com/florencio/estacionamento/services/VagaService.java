package com.florencio.estacionamento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florencio.estacionamento.domain.Vaga;
import com.florencio.estacionamento.repositories.VagaRepository;
import com.florencio.estacionamento.services.exceptions.ObjectNotFoundException;

@Service
public class VagaService {
	
	@Autowired
	private VagaRepository repo;
	
	public Vaga findById(Integer id) {
		Optional<Vaga> obj = repo.findById(id);
		
		return  obj.orElseThrow(()-> new ObjectNotFoundException("Id não encontrado"));
	}

}
