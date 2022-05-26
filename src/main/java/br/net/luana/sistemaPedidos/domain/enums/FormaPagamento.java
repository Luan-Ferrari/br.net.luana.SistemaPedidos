package br.net.luana.sistemaPedidos.domain.enums;

public enum FormaPagamento {

    dinheiro(1, "Dinheiro"),
    pix(2, "PIX"),
    cartaoDebito(3, "Cartão Débito"),
    cartaoCredio(4, "Cartão Crédito"),
    deposito(5, "Depósito"),
    transferencia(6, "Transferência"),
    cheques(7, "Cheques");


    private int codigo;
    private String descricao;

    FormaPagamento(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static FormaPagamento toEnum (Integer codigo) {
        if(codigo==null) {
            return null;
        }

        for (FormaPagamento formaPagamento : FormaPagamento.values()) {
            if(codigo.equals(formaPagamento.getCodigo())) {
                return formaPagamento;
            }
        }

        throw new IllegalArgumentException(("Id inválido: " + codigo));
    }
}
