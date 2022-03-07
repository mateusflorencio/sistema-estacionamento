package com.florencio.estacionamento.resourses;

import java.util.List;

import com.florencio.estacionamento.domain.Estacionamento;
import com.florencio.estacionamento.services.EstacionamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/estacionamento")
public class EstacionamentoResourse {

	@Autowired
	private EstacionamentoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Estacionamento> find(@PathVariable Integer id) {
		Estacionamento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Estacionamento>> findAll() {
		List<Estacionamento> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

}
