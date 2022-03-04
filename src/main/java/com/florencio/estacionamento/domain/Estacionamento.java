package com.florencio.estacionamento.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estacionamento implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Date dataEntrada;
	private Atendente atendente;
	private Usuario usuario;
	private Veiculo veiculo;
	private Vaga vaga;
	
	public Estacionamento() {
		
	}

	public Estacionamento(Integer id, Date dataEntrada, Atendente atendente, Usuario usuario, Veiculo veiculo, Vaga vaga) {
		super();
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.atendente = atendente;
		this.usuario = usuario;
		this.veiculo = veiculo;
		this.vaga = vaga;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return dataEntrada;
	}

	public void setData(Date data) {
		this.dataEntrada = data;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacionamento other = (Estacionamento) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
