package br.net.luana.sistemaPedidos.domain.enums;

public enum TipoPedido {

    balcao(1, "Balcão"),
    condicional(2, "Condicional"),
    loja(3, "Loja"),
    internet(4, "Internet");


    private int codigo;
    private String descricao;

    TipoPedido(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoPedido toEnum (Integer codigo) {
        if(codigo==null) {
            return null;
        }

        for (TipoPedido tipoPedido : TipoPedido.values()) {
            if(codigo.equals(tipoPedido.getCodigo())) {
                return tipoPedido;
            }
        }

        throw new IllegalArgumentException(("Id inválido: " + codigo));
    }
}
