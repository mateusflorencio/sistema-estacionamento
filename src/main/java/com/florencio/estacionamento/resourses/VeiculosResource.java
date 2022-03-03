package com.florencio.estacionamento.resourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.florencio.estacionamento.domain.Veiculos;
import com.florencio.estacionamento.services.VeiculosService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculosResource {
	
	@Autowired
	private VeiculosService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Veiculos obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
