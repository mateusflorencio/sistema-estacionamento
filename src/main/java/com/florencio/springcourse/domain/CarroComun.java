package com.florencio.springcourse.domain;

import javax.persistence.Entity;

import com.florencio.springcourse.domain.enuns.CorCarroEnum;

@Entity
public class CarroComun extends Veiculos {
	static final long serialVersionUID = 1L;

	public CarroComun() {
		super();
	}

	public CarroComun(Integer id, String placa, Double tarifa, CorCarroEnum cor) {
		super(id, placa, tarifa, cor);
	}

}
