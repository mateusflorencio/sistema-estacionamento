package com.florencio.estacionamento.services;

import java.util.List;
import java.util.Optional;

import com.florencio.estacionamento.domain.Usuario;
import com.florencio.estacionamento.domain.Veiculo;
import com.florencio.estacionamento.domain.enuns.CorCarroEnum;
import com.florencio.estacionamento.domain.enuns.TipoVeiculoEnum;
import com.florencio.estacionamento.dto.VeiculoNewDTO;
import com.florencio.estacionamento.repositories.VeiculoRepository;
import com.florencio.estacionamento.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculosService {

	@Autowired
	private VeiculoRepository repo;

	@Autowired
	private UsuarioService usuarioService;

	public Veiculo findById(Integer id) {
		Optional<Veiculo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Veiculo.class.getName()));
	}

	public Veiculo insert(Veiculo entity) {
		repo.save(entity);
		return entity;
	}
	public List<Veiculo> findAll(){
		return repo.findAll();
	}

	public Veiculo fromDto (VeiculoNewDTO objDto){
		Usuario usuario = usuarioService.findById(objDto.getUsuarioId());
		Veiculo entity = new Veiculo(null, objDto.getPlaca(),
				CorCarroEnum.paraEnum(objDto.getCor()),
				TipoVeiculoEnum.paraEnum(objDto.getTipoVeiculo()), usuario);

		return entity;
	}

}
