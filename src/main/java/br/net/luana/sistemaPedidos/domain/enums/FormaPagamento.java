package br.net.luana.sistemaPedidos.domain.enums;

public enum FormaPagamento {

    dinheiro(1, "Dinheiro"),
    pix(2, "PIX"),
    cartaoDebito(3, "Cartão Débito"),
    cartaoCredio(4, "Cartão Crédito"),
    deposito(5, "Depósito"),
    transferencia(6, "Transferência"),
    cheques(7, "Cheques");


    private int id;
    private String descricao;

    FormaPagamento(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static FormaPagamento toEnum (Integer id) {
        if(id==null) {
            return null;
        }

        for (FormaPagamento formaPagamento : FormaPagamento.values()) {
            if(id.equals(formaPagamento.getId())) {
                return formaPagamento;
            }
        }

        throw new IllegalArgumentException(("Id inválido: " + id));
    }
}
