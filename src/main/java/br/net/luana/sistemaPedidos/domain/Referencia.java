package br.net.luana.sistemaPedidos.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Referencia implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer codigo;

    private Boolean alteraPreco;

    private Double valorAlteracao;

    @ManyToOne
    @JoinColumn(name = "classe_produto_id")
    private ClasseProduto classeProduto;

    public Referencia() {
    }

    public Referencia(Integer id, Integer codigo, Boolean alteraPreco, Double valorAlteracao) {
        this.id = id;
        this.codigo = codigo;
        this.alteraPreco = alteraPreco;
        this.valorAlteracao = valorAlteracao;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Boolean getAlteraPreco() {
        return alteraPreco;
    }

    public void setAlteraPreco(Boolean alteraPreco) {
        this.alteraPreco = alteraPreco;
    }

    public Double getValorAlteracao() {
        return valorAlteracao;
    }

    public void setValorAlteracao(Double valorAlteracao) {
        this.valorAlteracao = valorAlteracao;
    }

    public ClasseProduto getClasseProduto() {
        return classeProduto;
    }

    public void setClasseProduto(ClasseProduto classeProduto) {
        this.classeProduto = classeProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Referencia that = (Referencia) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
