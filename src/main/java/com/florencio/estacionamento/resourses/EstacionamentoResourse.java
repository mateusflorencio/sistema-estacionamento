package com.florencio.estacionamento.resourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.florencio.estacionamento.domain.Estacionamento;
import com.florencio.estacionamento.services.EstacionamentoService;

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

}
