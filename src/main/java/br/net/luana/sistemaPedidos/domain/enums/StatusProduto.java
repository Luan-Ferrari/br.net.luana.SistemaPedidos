package br.net.luana.sistemaPedidos.domain.enums;

public enum StatusProduto {

    ativo(1, "Ativo"),
    inativo(2, "Inativo"),
    desenvolvimento(3, "Em Desenvolvimento");


    private int codigo;
    private String descricao;

    StatusProduto(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusProduto toEnum (Integer codigo) {
        if(codigo==null) {
            return null;
        }

        for (StatusProduto statusProduto : StatusProduto.values()) {
            if(codigo.equals(statusProduto.getCodigo())) {
                return statusProduto;
            }
        }

        throw new IllegalArgumentException(("Id inválido: " + codigo));
    }
}
