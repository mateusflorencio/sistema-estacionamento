package com.florencio.estacionamento.services;

import java.util.List;
import java.util.Optional;

import com.florencio.estacionamento.domain.Atendente;
import com.florencio.estacionamento.domain.Estacionamento;
import com.florencio.estacionamento.domain.Usuario;
import com.florencio.estacionamento.domain.Veiculo;
import com.florencio.estacionamento.domain.enuns.TipoCobranca;
import com.florencio.estacionamento.dto.EstacionamentoNewDTO;
import com.florencio.estacionamento.repositories.EstacionamentoRepository;
import com.florencio.estacionamento.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstacionamentoService {

	@Autowired
	private EstacionamentoRepository repo;

	@Autowired
	private AtendenteService atendenteService;

	@Autowired
	private VeiculosService veiculosService;

	public Estacionamento findById(Integer id) {
		Optional<Estacionamento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + EstacionamentoService.class.getName()));
	}

	public List<Estacionamento> findAll() {
		return repo.findAll();
	}

	public Estacionamento insert(Estacionamento obj) {
		return repo.save(obj);
	}

	public Estacionamento fromDto(EstacionamentoNewDTO objDto) {
		Atendente atendente = atendenteService.findById(objDto.getAtendenteId());
		Veiculo veiculo = veiculosService.findPlaca(objDto.getPlaca());
		Usuario usuario = veiculo.getUsuario();

		Estacionamento obj = new Estacionamento(null,
				atendente,
				objDto.getDataEntrada(),
				objDto.getDataSaida(),
				TipoCobranca.paraEnum(objDto.getTipoCobrancaId()),
				usuario,
				veiculo);
		repo.save(obj);
		return obj;
	}

}
