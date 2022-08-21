package br.net.luana.sistemaPedidos.domain;

import br.net.luana.sistemaPedidos.domain.enums.StatusPedido;
import br.net.luana.sistemaPedidos.domain.enums.TipoPedido;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Pedido implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer tipoPedido;
    private LocalDate dataPedido;
    private LocalDate dataPrevisao;
    private LocalDate dataEntrega;

    private Integer statusPedido;

    private Integer pacote;

    @ManyToMany
    @JoinTable(name = "PEDIDO_ITEM",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> itens = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "PEDIDO_NOTA",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "nota_id"))
    private List<Nota> notas = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "PEDIDO_PAGAMENTO",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "pagamento_id"))
    private List<Pagamento> pagamentos = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(Integer id, TipoPedido tipoPedido, LocalDate dataPedido, LocalDate dataPrevisao,
                  LocalDate dataEntrega, StatusPedido statusPedido, Integer pacote) {
        this.id = id;
        this.tipoPedido = (tipoPedido == null) ? null : tipoPedido.getId();
        this.dataPedido = dataPedido;
        this.dataPrevisao = dataPrevisao;
        this.dataEntrega = dataEntrega;
        this.statusPedido = (statusPedido == null) ? null : statusPedido.getId();
        this.pacote = pacote;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoPedido getTipoPedido() {
        return TipoPedido.toEnum(tipoPedido);
    }

    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido.getId();
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalDate getDataPrevisao() {
        return dataPrevisao;
    }

    public void setDataPrevisao(LocalDate dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public StatusPedido getStatusPedido() {
        return StatusPedido.toEnum(statusPedido);
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido.getId();
    }

    public Integer getPacote() {
        return pacote;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public void setPacote(Integer pacote) {
        this.pacote = pacote;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
