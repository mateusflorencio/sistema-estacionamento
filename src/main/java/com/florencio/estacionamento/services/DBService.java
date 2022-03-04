package com.florencio.estacionamento.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florencio.estacionamento.domain.Atendente;
import com.florencio.estacionamento.domain.Estacionamento;
import com.florencio.estacionamento.domain.Usuario;
import com.florencio.estacionamento.domain.Vaga;
import com.florencio.estacionamento.domain.Veiculo;
import com.florencio.estacionamento.domain.enuns.CorCarroEnum;
import com.florencio.estacionamento.domain.enuns.TipoVeiculoEnum;
import com.florencio.estacionamento.repositories.AtendenteRepository;
import com.florencio.estacionamento.repositories.EstacionamentoRepository;
import com.florencio.estacionamento.repositories.UsuarioRepository;
import com.florencio.estacionamento.repositories.VagaRepository;
import com.florencio.estacionamento.repositories.VeiculoRepository;

@Service
public class DBService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AtendenteRepository atendenteRepository;

	@Autowired
	private EstacionamentoRepository estacionamentoRepository;

	@Autowired
	private VagaRepository vagaRepository;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public void instantiateTestDatabase() throws ParseException {

		Atendente a1 = new Atendente(null, "Mateus");

		atendenteRepository.save(a1);

		Usuario u1 = new Usuario(null, "Adria");
		Usuario u2 = new Usuario(null, "Marcos");
		Usuario u3 = new Usuario(null, "kassia");

		u1.getTelefone().add("11954188994");
		u2.getTelefone().add("1143350103");
		u3.getTelefone().add("1198476549");

		Veiculo veic1 = new Veiculo(null, "huk4859", CorCarroEnum.AMARELO, TipoVeiculoEnum.CARRO, u1);
		Veiculo veic2 = new Veiculo(null, "gtf5648", CorCarroEnum.AZUL, TipoVeiculoEnum.GRANDEPORTE, u3);
		Veiculo veic3 = new Veiculo(null, "aaa1111", CorCarroEnum.LARANJA, TipoVeiculoEnum.MOTO, u2);

		u1.getVeiculo().add(veic1);
		u2.getVeiculo().add(veic2);
		u3.getVeiculo().add(veic3);

		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3));

		veiculoRepository.saveAll(Arrays.asList(veic1, veic2, veic3));

		Vaga v1 = new Vaga(null);
		Vaga v2 = new Vaga(null);
		Vaga v3 = new Vaga(null);

		vagaRepository.saveAll(Arrays.asList(v1, v2, v3));

		Estacionamento e1 = new Estacionamento(null, sdf.parse("22/22/2222 22:22:22"),a1,u1,veic1);

		estacionamentoRepository.saveAll(Arrays.asList(e1));

	}

}