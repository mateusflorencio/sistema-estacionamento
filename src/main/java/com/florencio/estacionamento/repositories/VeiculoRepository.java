package com.florencio.estacionamento.repositories;



import com.florencio.estacionamento.domain.Veiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>{

    
    @Query("from Veiculo where Placa = :placa")
    public Veiculo findByPlaca( @Param("placa") String placa);
	

}
