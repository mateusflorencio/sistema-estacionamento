package com.florencio.springcourse.domain;

import javax.persistence.Entity;

import com.florencio.springcourse.domain.enuns.CorCarroEnum;

@Entity
public class PorteGrande extends Veiculos {
	private static final long serialVersionUID = 1L;

	public PorteGrande() {
		super();
	}

	public PorteGrande(Integer id, String placa, Double tarifa, CorCarroEnum cor) {
		super(id, placa, tarifa, cor);
	}

}
