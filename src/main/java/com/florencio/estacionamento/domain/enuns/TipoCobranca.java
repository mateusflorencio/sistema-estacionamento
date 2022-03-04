package com.florencio.estacionamento.domain.enuns;

public enum TipoCobranca {

    AVULSO(1), DIARIA(2), MENSALISTA(3);

    private int code;

    public int getCode() {
        return code;
    }

    TipoCobranca(int i) {
        this.code = i;
    }

    public int getCode(int i) {
        return code;
    }

    public static TipoCobranca paraEnum(Integer id) {
        if (id == null) {
            return null;
        }

        for (TipoCobranca obj : TipoCobranca.values()) {
            if (id.equals(obj.getCode())) {
                return obj;
            }

        }

        throw new IllegalArgumentException("Id iválido:" + id);
    }

}
