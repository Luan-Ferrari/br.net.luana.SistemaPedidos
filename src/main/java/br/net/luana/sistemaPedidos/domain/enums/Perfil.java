package br.net.luana.sistemaPedidos.domain.enums;

public enum Perfil {

    ADMIN(1, "ROLE_ADMIN"),
    USUARIO(2, "ROLE_CLIENTE");


    private int id;
    private String descricao;

    Perfil(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Perfil toEnum (Integer id) {
        if(id==null) {
            return null;
        }

        for (Perfil perfil : Perfil.values()) {
            if(id.equals(perfil.getId())) {
                return perfil;
            }
        }

        throw new IllegalArgumentException(("Id inválido: " + id));
    }
}
