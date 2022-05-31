package br.net.luana.sistemaPedidos.domain;

import br.net.luana.sistemaPedidos.domain.enums.StatusItem;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class HistoricoEstoqueItem implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Item item;

    private Estoque estoqueAnterior;
    private Estoque estoqueAtual;

    public HistoricoEstoqueItem() {
    }

    public HistoricoEstoqueItem(Integer id, Item item, Estoque estoqueAnterior, Estoque estoqueAtual) {
        this.id = id;
        this.item = item;
        this.estoqueAnterior = estoqueAnterior;
        this.estoqueAtual = estoqueAtual;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Estoque getEstoqueAnterior() {
        return estoqueAnterior;
    }

    public void setEstoqueAnterior(Estoque estoqueAnterior) {
        this.estoqueAnterior = estoqueAnterior;
    }

    public Estoque getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(Estoque estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricoEstoqueItem that = (HistoricoEstoqueItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
