package com.florencio.estacionamento.dto;

import com.florencio.estacionamento.domain.Veiculo;

public class VeiculoNewDTO {

    private String placa;
    private Integer cor;
    private Integer tipoVeiculo;
    private Integer usuarioId;

    public VeiculoNewDTO() {
    }

    public VeiculoNewDTO(String placa, Integer cor, Integer tipoVeiculo, Integer usuarioId) {
        this.placa = placa;
        this.cor = cor;
        this.tipoVeiculo = tipoVeiculo;
        this.usuarioId = usuarioId;
    }

    public VeiculoNewDTO(Veiculo veiculo) {
        this.placa = veiculo.getPlaca();
        this.cor = veiculo.getCor().getCode();
        this.tipoVeiculo = veiculo.getTipoveiculo().getCode();
        this.usuarioId = veiculo.getUsuario().getId();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getCor() {
        return cor;
    }

    public void setCor(Integer cor) {
        this.cor = cor;
    }

    public Integer getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(Integer tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

}
