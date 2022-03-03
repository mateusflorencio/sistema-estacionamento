package com.florencio.estacionamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.florencio.estacionamento.domain.Atendente;


@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, Integer>{
	

}
