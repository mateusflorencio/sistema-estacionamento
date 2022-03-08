package com.florencio.estacionamento.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.florencio.estacionamento.domain.enuns.TipoCobranca;

@Entity
public class Estacionamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataEntrada;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataSaida;

	private Integer tipoCobranca;

	@ManyToOne
	@JoinColumn(name = "atendente_id")
	private Atendente atendente;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "veiculos_id")
	private Veiculo veiculo;

	private Integer intervaloHoras;

	private Integer intervaloDias;

	private Double total=0.0;

	public Estacionamento() {

	}

	public Estacionamento(Integer id,
			Atendente atendente,
			Date dataEntrada,
			Date dataSaida,
			TipoCobranca tipoCobranca,
			Usuario usuario,
			Veiculo veiculo) {
		super();
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.atendente = atendente;
		this.usuario = usuario;
		this.veiculo = veiculo;
		this.tipoCobranca = tipoCobranca.getCode();
		this.intervaloHoras = calculoIntervaloHoras();
		this.intervaloDias = calculoIntervaloDias();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public TipoCobranca getTipoCobranca() {
		return TipoCobranca.paraEnum(tipoCobranca);
	}

	public void setTipoCobranca(TipoCobranca tipoCobranca) {
		this.tipoCobranca = tipoCobranca.getCode();
	}

	public Integer getIntervaloHoras() {
		return intervaloHoras;
	}

	public void setIntervaloHoras(Integer intervaloHoras) {
		this.intervaloHoras = intervaloHoras;
	}

	public Integer getIntervaloDias() {
		return intervaloDias;
	}

	public void setIntervaloDias(Integer intervaloDias) {
		this.intervaloDias = intervaloDias;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
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

	public int calculoIntervaloDias() {
		if (dataSaida == null) {
			return 0;
		}
		int resultado = (int) ((dataEntrada.getTime() - dataSaida.getTime()) / 86400000L);
		return resultado < 0 ? resultado * -1 : resultado;
	}

	public int calculoIntervaloHoras() {
		if (dataSaida == null) {
			return 0;
		}
		int resultado = (int) ((dataEntrada.getTime() - dataSaida.getTime()) / (1000 * 60 * 60));
		return resultado < 0 ? resultado * -1 : resultado;
	}


}
