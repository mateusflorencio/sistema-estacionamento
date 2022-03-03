package com.florencio.estacionamento.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florencio.estacionamento.domain.Atendente;
import com.florencio.estacionamento.domain.Usuario;
import com.florencio.estacionamento.domain.Veiculos;
import com.florencio.estacionamento.domain.enuns.CorCarroEnum;
import com.florencio.estacionamento.repositories.AtendenteRepository;
import com.florencio.estacionamento.repositories.UsuarioRepository;
import com.florencio.estacionamento.repositories.VeiculosRepository;

@Service
public class DBService {

	@Autowired
	private VeiculosRepository veiculosRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AtendenteRepository atendenteRepository;

	public void instantiateTestDatabase() throws ParseException {

		Veiculos veic1 = new Veiculos(null, "huk4859", 10.00, CorCarroEnum.AMARELO);
		Veiculos veic2 = new Veiculos(null, "gtf5648", 10.00, CorCarroEnum.AZUL);
		Veiculos veic3 = new Veiculos(null, "aaa1111", 10.00, CorCarroEnum.LARANJA);

		veiculosRepository.saveAll(Arrays.asList(veic1, veic2, veic3));

		Usuario u1 = new Usuario(null, "Adria");
		Usuario u2 = new Usuario(null, "Marcos");
		Usuario u3 = new Usuario(null, "kassia");

		u1.getTelefone().add("11954188994");
		u2.getTelefone().add("1143350103");
		u3.getTelefone().add("1198476549");

		// u1.getVeiculo().add(veic1);
		// u2.getVeiculo().add(veic2);
		// u3.getVeiculo().add(veic3);

		Atendente a1 = new Atendente(null, "Mateus");

		atendenteRepository.save(a1);

		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3));
	}

}