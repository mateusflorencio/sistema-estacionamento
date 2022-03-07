package com.florencio.estacionamento.resourses;

import java.util.List;

import com.florencio.estacionamento.domain.Atendente;
import com.florencio.estacionamento.services.AtendenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/atendentes")
public class AtendenteResource {

	@Autowired
	private AtendenteService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Atendente> find(@PathVariable Integer id) {
		Atendente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Atendente>> findAll() {
		List<Atendente> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	

}
