package br.net.luana.sistemaPedidos.dto.enums;

import br.net.luana.sistemaPedidos.domain.enums.StatusItem;

import java.io.Serializable;

public class StatusItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String descricao;

    public StatusItemDTO() {
    }

    public StatusItemDTO(StatusItem enumObject) {
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
