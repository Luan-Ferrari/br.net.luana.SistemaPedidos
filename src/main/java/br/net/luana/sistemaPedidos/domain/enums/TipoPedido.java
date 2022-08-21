package br.net.luana.sistemaPedidos.domain.enums;

public enum TipoPedido {

    balcao(1, "Balcão"),
    condicional(2, "Condicional"),
    loja(3, "Loja"),
    internet(4, "Internet");


    private int id;
    private String descricao;

    TipoPedido(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoPedido toEnum (Integer id) {
        if(id==null) {
            return null;
        }

        for (TipoPedido tipoPedido : TipoPedido.values()) {
            if(id.equals(tipoPedido.getId())) {
                return tipoPedido;
            }
        }

        throw new IllegalArgumentException(("Id inválido: " + id));
    }
}
