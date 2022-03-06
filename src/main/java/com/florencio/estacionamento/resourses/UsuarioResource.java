package com.florencio.estacionamento.resourses;

import java.net.URI;

import com.florencio.estacionamento.domain.Usuario;
import com.florencio.estacionamento.dto.UsuarioNewDTO;
import com.florencio.estacionamento.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping(value="/insert")
	public ResponseEntity<Void> insert(@RequestBody UsuarioNewDTO entityDto) {
		Usuario entity = service.fromDTO(entityDto);
		service.insert(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	

}
