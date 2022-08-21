package br.net.luana.sistemaPedidos.domain;

import br.net.luana.sistemaPedidos.domain.enums.StatusProduto;
import br.net.luana.sistemaPedidos.domain.enums.Tamanho;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Produto implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer codigoProduto;
    private String descricao;

    private Boolean conjunto;
    private Double valorAtacado;
    private Double valorVarejo;

    private Integer statusProduto;

    @ManyToMany
    @JoinTable(name = "PRODUTO_COLECAO",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "colecao_id"))
    private List<Colecao> colecoes = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "clase_produto")
    private ClasseProduto classeProduto;

    @ElementCollection
    @CollectionTable(name = "produto_tamanhos_aceitos")
    private Set<Integer> tamanhosAceitos = new HashSet<>();

    @OneToMany(mappedBy = "produto")
    private List<Item> itens = new ArrayList<>();

    public Produto() {
    }

    public Produto(Integer id, Integer codigoProduto, String descricao, Boolean conjunto, Double valorAtacado, Double valorVarejo,
                   StatusProduto statusProduto) {
        this.id = id;
        this.codigoProduto = codigoProduto;
        this.descricao = descricao;
        this.conjunto = conjunto;
        this.valorAtacado = valorAtacado;
        this.valorVarejo = valorVarejo;
        this.statusProduto = (statusProduto == null) ? null : statusProduto.getId();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        this.statusProduto = (statusProduto == null) ? null : statusProduto.getId();
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

    public Set<Integer> getTamanhosAceitos() {
        return tamanhosAceitos;
    }

    public void setTamanhosAceitos(Set<Integer> tamanhosAceitos) {
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
