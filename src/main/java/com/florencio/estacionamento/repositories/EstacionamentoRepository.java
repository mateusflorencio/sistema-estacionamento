package com.florencio.estacionamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.florencio.estacionamento.domain.Estacionamento;

@Repository
public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Integer> {

}
