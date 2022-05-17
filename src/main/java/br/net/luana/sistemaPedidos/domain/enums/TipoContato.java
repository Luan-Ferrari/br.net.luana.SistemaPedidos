package br.net.luana.sistemaPedidos.domain.enums;

public enum TipoContato {

    teleone(1, "Somente Telefone"),
    telefoneWhats(2, "Telefone e WhatssApp"),
    email(3, "E-mail");

    private int codigo;
    private String descricao;

    TipoContato(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoContato toEnum (Integer codigo) {
        if(codigo==null) {
            return null;
        }

        for (TipoContato tipoContato : TipoContato.values()) {
            if(codigo.equals(tipoContato.getCodigo())) {
                return tipoContato;
            }
        }

        throw new IllegalArgumentException(("Id inválido: " + codigo));
    }
}
