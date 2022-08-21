package br.net.luana.sistemaPedidos.dto.enums;

import br.net.luana.sistemaPedidos.domain.enums.StatusProduto;

import java.io.Serializable;

public class StatusProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String descricao;

    public StatusProdutoDTO() {
    }

    public StatusProdutoDTO(StatusProduto enumObject) {
        this.id = enumObject.getId();
        this.descricao = enumObject.getDescricao();
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
