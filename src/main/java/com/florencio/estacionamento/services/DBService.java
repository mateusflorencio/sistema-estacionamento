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

		Usuario u1 = new Usuario(null, "Adria");
		Usuario u2 = new Usuario(null, "Marcos");
		Usuario u3 = new Usuario(null, "kassia");

		Veiculos veic1 = new Veiculos(null, "huk4859", CorCarroEnum.AMARELO);
		Veiculos veic2 = new Veiculos(null, "gtf5648", CorCarroEnum.AZUL);
		Veiculos veic3 = new Veiculos(null, "aaa1111", CorCarroEnum.LARANJA);

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

		veiculosRepository.saveAll(Arrays.asList(veic1, veic2, veic3));

		atendenteRepository.save(a1);

	}

}