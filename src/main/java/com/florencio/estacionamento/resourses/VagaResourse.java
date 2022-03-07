package com.florencio.estacionamento.resourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.florencio.estacionamento.domain.Vaga;
import com.florencio.estacionamento.services.VagaService;

@RestController
@RequestMapping(value = "/vagas")
public class VagaResourse {

	@Autowired
	private VagaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vaga> find(@PathVariable Integer id) {
		Vaga obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Vaga>> findAll(){
		List<Vaga> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
