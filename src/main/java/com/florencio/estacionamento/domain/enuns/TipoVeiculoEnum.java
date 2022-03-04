package com.florencio.estacionamento.domain.enuns;

public enum TipoVeiculoEnum {
	
	CARRO(1), MOTO(2), GRANDEPORTE(3);
	
	private int code;

	TipoVeiculoEnum(int i) {
		this.code=i;
	}

	public int getCode() {
		return code;
	}

	public static TipoVeiculoEnum paraEnum(Integer id) {
		if(id==null) {
			return null;
		}
		
		for (TipoVeiculoEnum obj : TipoVeiculoEnum.values()) {
				if(id.equals(obj.getCode())){
					return obj;
				}
			
		}
		
		throw new IllegalArgumentException("Id iválido:" + id);
	}
	
	
	
	
	

}
