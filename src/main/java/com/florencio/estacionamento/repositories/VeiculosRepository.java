package com.florencio.estacionamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.florencio.estacionamento.domain.Veiculos;


@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, Integer>{
	

}
