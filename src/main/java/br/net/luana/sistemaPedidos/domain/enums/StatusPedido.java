package br.net.luana.sistemaPedidos.domain.enums;

public enum StatusPedido {

    pedido(1, "Pedido"),
    producao(2, "Em Produção"),
    finalizado(3, "Finalizado"),
    entregue(4, "Entregue");


    private int codigo;
    private String descricao;

    StatusPedido(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusPedido toEnum (Integer codigo) {
        if(codigo==null) {
            return null;
        }

        for (StatusPedido statusPedido : StatusPedido.values()) {
            if(codigo.equals(statusPedido.getCodigo())) {
                return statusPedido;
            }
        }

        throw new IllegalArgumentException(("Id inválido: " + codigo));
    }
}
