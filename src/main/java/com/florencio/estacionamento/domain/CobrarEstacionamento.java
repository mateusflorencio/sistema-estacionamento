package com.florencio.estacionamento.domain;

import java.util.Date;

public class CobrarEstacionamento {

    public Double entradaDeValoresPraCobrar(Estacionamento estacionamento) {
        Date dataInicial = estacionamento.getDataEntrada();
        Date dataSaida = estacionamento.getDataSaida();
        Integer tipoVeiculo = estacionamento.getVeiculo().getTipoveiculo().getCode();
        Double valor=realizarLogicaDaTarifa(dataInicial,dataSaida,tipoVeiculo);

        return valor;
    }

    private Double realizarLogicaDaTarifa(Date dataInicial, Date dataSaida, Integer tipoVeiculo) {
        
        return null;
    }

}
