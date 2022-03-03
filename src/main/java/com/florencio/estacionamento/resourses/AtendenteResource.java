package com.florencio.estacionamento.resourses;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.florencio.estacionamento.domain.Atendente;
import com.florencio.estacionamento.repositories.AtendenteRepository;

@RestController
@RequestMapping(value = "/atendente")
public class AtendenteResource {
	
	@Autowired
	private AtendenteRepository service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Optional<Atendente> obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
