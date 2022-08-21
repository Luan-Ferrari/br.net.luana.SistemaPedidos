package br.net.luana.sistemaPedidos.dto.enums;

import br.net.luana.sistemaPedidos.domain.enums.FormaPagamento;

import java.io.Serializable;

public class FormaPagamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String descricao;

    public FormaPagamentoDTO(FormaPagamento enumObject) {
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
