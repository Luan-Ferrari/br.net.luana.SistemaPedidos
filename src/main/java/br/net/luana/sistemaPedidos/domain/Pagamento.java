package br.net.luana.sistemaPedidos.domain;

import br.net.luana.sistemaPedidos.domain.enums.FormaPagamento;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Pagamento implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dataPagamento;
    private Integer formaPagamento;
    private Double valorPago;
    private Boolean pagamentoConcluido;

    @ManyToMany(mappedBy = "pagamentos")
    private List<Pedido> pedidos = new ArrayList<>();

    public Pagamento() {
    }

    public Pagamento(Integer id, LocalDate dataPagamento, FormaPagamento formaPagamento, Double valorPago,
                     Boolean pagamentoConcluido) {
        this.id = id;
        this.dataPagamento = dataPagamento;
        this.formaPagamento = (formaPagamento == null) ? null : formaPagamento.getId();
        this.valorPago = valorPago;
        this.pagamentoConcluido = pagamentoConcluido;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public FormaPagamento getFormaPagamento() {
        return FormaPagamento.toEnum(formaPagamento);
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento.getId();
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Boolean getPagamentoConcluido() {
        return pagamentoConcluido;
    }

    public void setPagamentoConcluido(Boolean pagamentoConcluido) {
        this.pagamentoConcluido = pagamentoConcluido;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
