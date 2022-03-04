package com.florencio.estacionamento.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.florencio.estacionamento.domain.enuns.CorCarroEnum;

@Entity
public class Veiculos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String Placa;
	private Integer cor;

	public Veiculos() {

	}

	public Veiculos(Integer id, String placa, CorCarroEnum cor) {
		super();
		this.id = id;
		Placa = placa;
		this.cor = (cor == null) ? null : cor.getCode();
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
		Veiculos other = (Veiculos) obj;
		return Objects.equals(id, other.id);
	}

}
