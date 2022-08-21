package br.net.luana.sistemaPedidos.domain.enums;

public enum Tamanho {

    pp(101, "PP"),
    p(102, "P"),
    m(103, "M"),
    g(104, "G"),
    gg(105, "GG"),
    xgg(106, "XGG"),
    t1bebe(201, "T1 Bebê"),
    t2bebe(202, "T2 Bebê"),
    t3bebe(203, "T3 Bebê"),
    t1inf(211, "T1 Infantil"),
    t2inf(212, "T2 Infantil"),
    t3inf(213, "T3 Infantil"),
    t4inf(214, "T4 Infantil"),
    t6inf(215, "T6 Infantil"),
    t8inf(216, "T8 Infantil"),
    t10inf(217, "T10 Infantil"),
    t12inf(218, "T12 Infantil"),
    t14inf(219, "T14 Infantil"),
    t48(121, "T48"),
    t50(122, "T50"),
    t52(123, "T52"),
    personalizado(301, "Personalizado");


    private int id;
    private String descricao;

    Tamanho(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Tamanho toEnum (Integer id) {
        if(id==null) {
            return null;
        }

        for (Tamanho tamanho : Tamanho.values()) {
            if(id.equals(tamanho.getId())) {
                return tamanho;
            }
        }

        throw new IllegalArgumentException(("Id inválido: " + id));
    }
}
