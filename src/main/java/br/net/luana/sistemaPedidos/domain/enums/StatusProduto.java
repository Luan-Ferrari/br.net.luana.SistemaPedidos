package br.net.luana.sistemaPedidos.domain.enums;

public enum StatusProduto {

    ativo(1, "Ativo"),
    inativo(2, "Inativo"),
    desenvolvimento(3, "Em Desenvolvimento");


    private int id;
    private String descricao;

    StatusProduto(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusProduto toEnum (Integer id) {
        if(id==null) {
            return null;
        }

        for (StatusProduto statusProduto : StatusProduto.values()) {
            if(id.equals(statusProduto.getId())) {
                return statusProduto;
            }
        }

        throw new IllegalArgumentException(("Id inválido: " + id));
    }
}
