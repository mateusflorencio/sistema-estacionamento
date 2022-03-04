package com.florencio.estacionamento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florencio.estacionamento.domain.Estacionamento;
import com.florencio.estacionamento.repositories.EstacionamentoRepository;
import com.florencio.estacionamento.services.exceptions.ObjectNotFoundException;

@Service
public class EstacionamentoService {

	@Autowired
	private EstacionamentoRepository repo;

	public Estacionamento findById(Integer id) {
		Optional<Estacionamento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("id não encotrado"));
	}

}
