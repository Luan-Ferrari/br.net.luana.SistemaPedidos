package br.net.luana.sistemaPedidos.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cor implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer codigoNaColecao;
    private Boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "colecao_id")
    private Colecao colecao;

    public Cor() {
    }

    public Cor(Integer id, Integer codigoNaColecao, Boolean disponivel, Colecao colecao) {
        this.id = id;
        this.codigoNaColecao = codigoNaColecao;
        this.disponivel = disponivel;
        this.colecao = colecao;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigoNaColecao() {
        return codigoNaColecao;
    }

    public void setCodigoNaColecao(Integer codigoNaColecao) {
        this.codigoNaColecao = codigoNaColecao;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Colecao getColecao() {
        return colecao;
    }

    public void setColecao(Colecao colecao) {
        this.colecao = colecao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cor cor = (Cor) o;
        return Objects.equals(id, cor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
