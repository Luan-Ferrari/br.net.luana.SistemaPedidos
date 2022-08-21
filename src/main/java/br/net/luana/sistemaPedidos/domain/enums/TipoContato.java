package br.net.luana.sistemaPedidos.domain.enums;

public enum TipoContato {

    telefone(1, "Somente Telefone"),
    telefoneWhats(2, "Telefone e WhatssApp"),
    email(3, "E-mail");

    private int id;
    private String descricao;

    TipoContato(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoContato toEnum (Integer id) {
        if(id==null) {
            return null;
        }

        for (TipoContato tipoContato : TipoContato.values()) {
            if(id.equals(tipoContato.getId())) {
                return tipoContato;
            }
        }

        throw new IllegalArgumentException(("Id inválido: " + id));
    }
}
