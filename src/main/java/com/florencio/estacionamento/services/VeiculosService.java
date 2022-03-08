package com.florencio.estacionamento.services;

import java.util.List;
import java.util.Optional;

import com.florencio.estacionamento.domain.Usuario;
import com.florencio.estacionamento.domain.Veiculo;
import com.florencio.estacionamento.domain.enuns.CorCarroEnum;
import com.florencio.estacionamento.domain.enuns.TipoVeiculoEnum;
import com.florencio.estacionamento.dto.VeiculoNewDTO;
import com.florencio.estacionamento.repositories.VeiculoRepository;
import com.florencio.estacionamento.services.exceptions.DataIntegrityException;
import com.florencio.estacionamento.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

	public Veiculo findPlaca(String placa){
		return	repo.findByPlaca(placa);
	}


	public Veiculo fromDto (VeiculoNewDTO objDto){
		Usuario usuario = usuarioService.findById(objDto.getUsuarioId());
		Veiculo entity = new Veiculo(null, objDto.getPlaca(),
				CorCarroEnum.paraEnum(objDto.getCor()),
				TipoVeiculoEnum.paraEnum(objDto.getTipoVeiculo()), usuario);

		return entity;
	}

	public Veiculo update(Veiculo obj){
		Veiculo veiculo = findById(obj.getId());
		veiculo.setCor(obj.getCor());
		veiculo.setPlaca(obj.getPlaca());
		veiculo.setTipoveiculo(obj.getTipoveiculo());
		veiculo.setUsuario(obj.getUsuario());

		return repo.save(veiculo);
	}

    public void delete(Integer id) {
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possivel excluir porque há entidades relacionadas");
		}
    }
	}
