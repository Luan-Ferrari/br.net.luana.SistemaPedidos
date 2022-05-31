package br.net.luana.sistemaPedidos.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Opcao implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String opcao;
    private Boolean alteraPreco;
    private Double valorAlteracao;
    private String textoLivre;

    @ManyToMany(mappedBy = "opcoes")
    private List<Personalizacao> personalizacoes = new ArrayList<>();

    public Opcao() {
    }

    public Opcao(Integer id, String opcao, Boolean alteraPreco, Double valorAlteracao, String textoLivre) {
        this.id = id;
        this.opcao = opcao;
        this.alteraPreco = alteraPreco;
        this.valorAlteracao = valorAlteracao;
        this.textoLivre = textoLivre;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
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

    public String getTextoLivre() {
        return textoLivre;
    }

    public void setTextoLivre(String textoLivre) {
        this.textoLivre = textoLivre;
    }

    public List<Personalizacao> getPersonalizacoes() {
        return personalizacoes;
    }

    public void setPersonalizacoes(List<Personalizacao> personalizacoes) {
        this.personalizacoes = personalizacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opcao that = (Opcao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
