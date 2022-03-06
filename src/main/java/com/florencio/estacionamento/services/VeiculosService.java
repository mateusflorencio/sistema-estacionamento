package com.florencio.estacionamento.services;

import java.util.Optional;

import com.florencio.estacionamento.domain.Veiculo;
import com.florencio.estacionamento.repositories.VeiculoRepository;
import com.florencio.estacionamento.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculosService {
	
	@Autowired
	private VeiculoRepository repo;
	
	public Veiculo findById(Integer id) {
		Optional<Veiculo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
			"Objeto não encontrado! Id: " + id + ", Tipo: " + Veiculo.class.getName()));
	}

}
