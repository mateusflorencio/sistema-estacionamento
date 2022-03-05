package com.florencio.estacionamento.services;

import com.florencio.estacionamento.domain.Estacionamento;
import com.florencio.estacionamento.domain.enuns.TipoCobranca;
import com.florencio.estacionamento.domain.enuns.TipoVeiculoEnum;

import org.springframework.stereotype.Service;

@Service
public class MetodoCobranca {
   
    
    public static  Double calcularTarifa(Estacionamento park) {

        Double valor = 0.00;

        if (park.getTipoCobranca() == TipoCobranca.AVULSO &&
                park.getVeiculo().getTipoveiculo() == TipoVeiculoEnum.MOTO) {
            valor = (double) (3 + (park.getIntervaloHoras()*2));
        } else if (park.getTipoCobranca() == TipoCobranca.AVULSO &&
                park.getVeiculo().getTipoveiculo() == TipoVeiculoEnum.CARRO) {
            valor = (double) (5 + (park.getIntervaloHoras()*2));
        } else if (park.getTipoCobranca() == TipoCobranca.AVULSO &&
                park.getVeiculo().getTipoveiculo() == TipoVeiculoEnum.GRANDEPORTE) {
            valor = (double) (10 + (park.getIntervaloHoras()*4));
        } else if (park.getTipoCobranca() == TipoCobranca.DIARIA &&
                park.getVeiculo().getTipoveiculo() == TipoVeiculoEnum.MOTO) {
            valor = (double) park.getIntervaloDias()*20;
        } else if (park.getTipoCobranca() == TipoCobranca.DIARIA &&
                park.getVeiculo().getTipoveiculo() == TipoVeiculoEnum.CARRO) {
            valor = (double) park.getIntervaloDias()*30;
        } else if (park.getTipoCobranca() == TipoCobranca.DIARIA &&
                park.getVeiculo().getTipoveiculo() == TipoVeiculoEnum.GRANDEPORTE) {
            valor = (double) park.getIntervaloDias()*60;
        }

        return valor;
    }

}
