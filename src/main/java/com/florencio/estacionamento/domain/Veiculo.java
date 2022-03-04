package com.florencio.estacionamento.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.florencio.estacionamento.domain.enuns.CorCarroEnum;
import com.florencio.estacionamento.domain.enuns.TipoVeiculoEnum;

@Entity
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String Placa;
	private Integer cor;
	private Integer tipoVeiculo;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Veiculo() {

	}

	public Veiculo(Integer id, String placa, CorCarroEnum cor, TipoVeiculoEnum tipo, Usuario usuario) {
		super();
		this.id = id;
		Placa = placa;
		this.cor = (cor == null) ? null : cor.getCode();
		this.tipoVeiculo =(tipo ==null) ? null : tipo.getCode();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return Placa;
	}

	public void setPlaca(String placa) {
		Placa = placa;
	}

	public CorCarroEnum getCor() {
		return CorCarroEnum.paraEnum(cor);
	}

	public void setCor(CorCarroEnum corID) {
		this.cor = corID.getCode();
	}

	public TipoVeiculoEnum getTipoveiculo() {
		return TipoVeiculoEnum.paraEnum(tipoVeiculo);
	}

	public void setTipoveiculo(TipoVeiculoEnum tipoId) {
		this.tipoVeiculo = tipoId.getCode();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(id, other.id);
	}

}
