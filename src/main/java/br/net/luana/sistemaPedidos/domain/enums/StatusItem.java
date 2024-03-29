package br.net.luana.sistemaPedidos.domain.enums;

public enum StatusItem {

    solicitado(1, "Solicitado"),
    cortado(2, "Cortado"),
    producaofabrixa(3, "Produção na Fábrica"),
    producaoterceirizada(4, "Produção Terceirizada"),
    aguardando(5, "Aguardando"),
    prontoaguardando(6, "Pronto e Aguardando "),
    prontopedidofinalizado(7, "Pronto e Pedido Finalizado"),
    estoque(8, "Em Estoque"),
    vendido(9, "Vendido"),
    devolvido(10, "Devolvido Pelo Cliente"),
    descartado(11, "Descartado");


    private int id;
    private String descricao;

    StatusItem(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusItem toEnum (Integer id) {
        if(id==null) {
            return null;
        }

        for (StatusItem statusItem : StatusItem.values()) {
            if(id.equals(statusItem.getId())) {
                return statusItem;
            }
        }

        throw new IllegalArgumentException(("Id inválido: " + id));
    }
}
