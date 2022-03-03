package com.florencio.springcourse.domain;

import javax.persistence.Entity;

import com.florencio.springcourse.domain.enuns.CorCarroEnum;

@Entity
public class Moto extends Veiculos {
	private static final long serialVersionUID = 1L;

	public Moto() {
		super();
	}

	public Moto(Integer id, String placa, Double tarifa, CorCarroEnum cor) {
		super(id, placa, tarifa, cor);
	}

}
