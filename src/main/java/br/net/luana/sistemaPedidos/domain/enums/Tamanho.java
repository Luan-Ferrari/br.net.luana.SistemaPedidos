package br.net.luana.sistemaPedidos.domain.enums;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public enum Tamanho {

    pp(1, "PP"),
    p(2, "P"),
    m(3, "M"),
    g(4, "G"),
    gg(5, "GG"),
    xgg(6, "XGG"),
    t1bebe(7, "T1 Bebê"),
    t2bebe(8, "T2 Bebê"),
    t3bebe(9, "T3 Bebê"),
    t1inf(10, "T1 Infantil"),
    t2inf(11, "T2 Infantil"),
    t3inf(12, "T3 Infantil"),
    t4inf(13, "T4 Infantil"),
    t6inf(14, "T6 Infantil"),
    t8inf(15, "T8 Infantil"),
    t10inf(16, "T10 Infantil"),
    t12inf(17, "T12 Infantil"),
    t14inf(18, "T14 Infantil"),
    t48(19, "T48"),
    t50(20, "T50"),
    t52(21, "T52"),
    personalizado(22, "Personalizado");


    private int codigo;
    private String descricao;

    Tamanho(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Tamanho toEnum (Integer codigo) {
        if(codigo==null) {
            return null;
        }

        for (Tamanho tamanho : Tamanho.values()) {
            if(codigo.equals(tamanho.getCodigo())) {
                return tamanho;
            }
        }

        throw new IllegalArgumentException(("Id inválido: " + codigo));
    }
}
