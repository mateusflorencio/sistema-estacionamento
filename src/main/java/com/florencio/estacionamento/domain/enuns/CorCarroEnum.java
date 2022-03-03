package com.florencio.estacionamento.domain.enuns;

public enum CorCarroEnum {
	
	VERMELHO(1), AZUL(2), PRETO(3), PRATA(4), BRANCO(5), VERDE(6), AMARELO(7), ROSA(8), MARROM(9), LARANJA(10);
	
	private int code;

	CorCarroEnum(int i) {
		this.code= i;
	}

	public int getCode() {
		return code;
	}
	
	public static CorCarroEnum paraEnum(Integer id) {
		if (id == null) {
			return null;
		}
		
		for (CorCarroEnum x : CorCarroEnum.values()) {
			if(id.equals(x.getCode())) {
				return x;
			}
			
		}
		
		throw new IllegalArgumentException("Id iválido:" + id);
	}
	

}
