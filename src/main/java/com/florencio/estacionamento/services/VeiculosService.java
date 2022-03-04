package com.florencio.estacionamento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florencio.estacionamento.domain.Veiculo;
import com.florencio.estacionamento.repositories.VeiculoRepository;

@Service
public class VeiculosService {
	
	@Autowired
	private VeiculoRepository repo;
	
	public Veiculo findById(Integer id) {
		Optional<Veiculo> obj = repo.findById(id);
		return obj.orElseThrow(()-> new IllegalArgumentException("Id não encontrado"));
	}

}
