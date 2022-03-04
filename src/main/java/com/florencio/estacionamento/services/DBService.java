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
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public void instantiateTestDatabase() throws ParseException {

		Usuario u1 = new Usuario(null, "Adria");
		Usuario u2 = new Usuario(null, "Marcos");
		Usuario u3 = new Usuario(null, "kassia");

		Veiculo veic1 = new Veiculo(null, "huk4859", CorCarroEnum.AMARELO);
		Veiculo veic2 = new Veiculo(null, "gtf5648", CorCarroEnum.AZUL);
		Veiculo veic3 = new Veiculo(null, "aaa1111", CorCarroEnum.LARANJA);

		u1.getVeiculo().add(veic1);
		u2.getVeiculo().add(veic2);
		u3.getVeiculo().add(veic3);

		veic1.setUsuario(u1);
		veic2.setUsuario(u2);
		veic3.setUsuario(u3);

		u1.getTelefone().add("11954188994");
		u2.getTelefone().add("1143350103");
		u3.getTelefone().add("1198476549");

		Atendente a1 = new Atendente(null, "Mateus");
		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3));

		veiculoRepository.saveAll(Arrays.asList(veic1, veic2, veic3));

		atendenteRepository.save(a1);

		Vaga v1 = new Vaga(null);
		Vaga v2 = new Vaga(null);
		Vaga v3 = new Vaga(null);

		vagaRepository.saveAll(Arrays.asList(v1, v2, v3));
		
		
//		Estacionamento e1 = new Estacionamento(1, sdf.parse("2022/12/12 14:43:00"), a1, u2, veic1, v1);
//		Estacionamento e2 = new Estacionamento(2, sdf.parse("2022/12/12 23:40:30"), a1, u1, veic2, v2);
//		
//		estacionamentoRepository.saveAll(Arrays.asList(e1,e2));

	}

}