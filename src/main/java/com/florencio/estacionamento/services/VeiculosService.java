package com.florencio.estacionamento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florencio.estacionamento.domain.Veiculos;
import com.florencio.estacionamento.repositories.VeiculosRepository;

@Service
public class VeiculosService {
	
	@Autowired
	private VeiculosRepository repo;
	
	public Veiculos findById(Integer id) {
		Optional<Veiculos> obj = repo.findById(id);
		return obj.orElseThrow(()-> new IllegalArgumentException("Id não encontrado"));
	}

}
