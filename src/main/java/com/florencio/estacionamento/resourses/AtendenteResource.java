package com.florencio.estacionamento.resourses;

import java.net.URI;
import java.util.List;

import com.florencio.estacionamento.domain.Atendente;
import com.florencio.estacionamento.services.AtendenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PutMapping;

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

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Atendente entity) {
		service.insert(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Atendente atendente) {
		Atendente obj = new Atendente(id, atendente.getNome());
		service.update(obj);
		return ResponseEntity.noContent().build();
	}

}
