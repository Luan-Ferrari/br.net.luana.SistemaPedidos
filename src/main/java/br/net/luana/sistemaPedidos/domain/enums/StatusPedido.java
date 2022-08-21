package br.net.luana.sistemaPedidos.domain.enums;

public enum StatusPedido {

    pedido(1, "Pedido"),
    producao(2, "Em Produção"),
    finalizado(3, "Finalizado"),
    entregue(4, "Entregue"),
    pago(5, "Pago"),
    acertofinalizado(6, "Acerto Finalizado");


    private int id;
    private String descricao;

    StatusPedido(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusPedido toEnum (Integer id) {
        if(id==null) {
            return null;
        }

        for (StatusPedido statusPedido : StatusPedido.values()) {
            if(id.equals(statusPedido.getId())) {
                return statusPedido;
            }
        }

        throw new IllegalArgumentException(("Id inválido: " + id));
    }
}
