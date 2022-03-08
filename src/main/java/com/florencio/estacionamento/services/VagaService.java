package com.florencio.estacionamento.services;

import java.util.List;
import java.util.Optional;

import com.florencio.estacionamento.domain.Vaga;
import com.florencio.estacionamento.repositories.VagaRepository;
import com.florencio.estacionamento.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VagaService {

	@Autowired
	private VagaRepository repo;

	public Vaga findById(Integer id) {
		Optional<Vaga> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
			"Objeto não encontrado! Id: " + id + ", Tipo: " + Vaga.class.getName()));
	}

	public List<Vaga> findAll(){
		return repo.findAll();
	}

	public Vaga insert(Vaga obj){
		return repo.save(obj);
	}

}
