package com.florencio.estacionamento.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.florencio.estacionamento.domain.Estacionamento;

public class EstacionamentoNewDTO {

    private Integer atendenteId;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataEntrada;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataSaida;
    private String placa;
    private Integer tipoCobrancaId;

    public EstacionamentoNewDTO() {

    }

    public EstacionamentoNewDTO(Integer atendenteId, Date dataEntrada, Date dataSaida, String placa,
            Integer tipoCobrancaId) {
        this.atendenteId = atendenteId;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.placa = placa;
        this.tipoCobrancaId = tipoCobrancaId;
    }

    public EstacionamentoNewDTO(Estacionamento entity) {
        this.atendenteId = entity.getAtendente().getId();
        this.dataEntrada = entity.getDataEntrada();
        this.dataSaida = entity.getDataSaida();
        this.tipoCobrancaId = entity.getTipoCobranca().getCode();

    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAtendenteId() {
        return atendenteId;
    }

    public void setAtendenteId(Integer atendenteId) {
        this.atendenteId = atendenteId;
    }

    public Integer getTipoCobrancaId() {
        return tipoCobrancaId;
    }

    public void setTipoCobrancaId(Integer tipoCobrancaId) {
        this.tipoCobrancaId = tipoCobrancaId;
    }
}
