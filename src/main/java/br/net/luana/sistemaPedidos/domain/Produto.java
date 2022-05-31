package br.net.luana.sistemaPedidos.domain;

import br.net.luana.sistemaPedidos.domain.enums.StatusPedido;
import br.net.luana.sistemaPedidos.domain.enums.StatusProduto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Produto implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer codigoProduto;
    private Boolean conjunto;
    private Double valorAtacado;
    private Double valorVarejo;

    private Integer statusProduto;

    @ManyToMany
    @JoinTable(name = "PRODUTO_COLECAO",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "colecao_id"))
    private List<Colecao> colecoes = new ArrayList<>();


    private ClasseProduto classeProduto;

    @ManyToMany
    @JoinTable(name = "PRODUTO_TAMANHOS_ACEITOS",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "tamanho_aceito_id"))
    private List<TamanhosAceitos> tamanhosAceitos = new ArrayList<>();

    @OneToMany(mappedBy = "produto")
    private List<Item> itens = new ArrayList<>();

    public Produto() {
    }

    public Produto(Integer id, Integer codigoProduto, Boolean conjunto, Double valorAtacado, Double valorVarejo,
                   StatusProduto statusProduto, ClasseProduto classeProduto) {
        this.id = id;
        this.codigoProduto = codigoProduto;
        this.conjunto = conjunto;
        this.valorAtacado = valorAtacado;
        this.valorVarejo = valorVarejo;
        this.statusProduto = (statusProduto == null) ? null : statusProduto.getCodigo();
        this.classeProduto = classeProduto;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Boolean getConjunto() {
        return conjunto;
    }

    public void setConjunto(Boolean conjunto) {
        this.conjunto = conjunto;
    }

    public Double getValorAtacado() {
        return valorAtacado;
    }

    public void setValorAtacado(Double valorAtacado) {
        this.valorAtacado = valorAtacado;
    }

    public Double getValorVarejo() {
        return valorVarejo;
    }

    public void setValorVarejo(Double valorVarejo) {
        this.valorVarejo = valorVarejo;
    }

    public StatusProduto getStatusProduto() {
        return StatusProduto.toEnum(statusProduto);
    }

    public void setStatusProduto(StatusProduto statusProduto) {
        this.statusProduto = (statusProduto == null) ? null : statusProduto.getCodigo();
    }

    public List<Colecao> getColecoes() {
        return colecoes;
    }

    public void setColecoes(List<Colecao> colecoes) {
        this.colecoes = colecoes;
    }

    public ClasseProduto getClasseProduto() {
        return classeProduto;
    }

    public void setClasseProduto(ClasseProduto classeProduto) {
        this.classeProduto = classeProduto;
    }

    public List<TamanhosAceitos> getTamanhosAceitos() {
        return tamanhosAceitos;
    }

    public void setTamanhosAceitos(List<TamanhosAceitos> tamanhosAceitos) {
        this.tamanhosAceitos = tamanhosAceitos;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto that = (Produto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
