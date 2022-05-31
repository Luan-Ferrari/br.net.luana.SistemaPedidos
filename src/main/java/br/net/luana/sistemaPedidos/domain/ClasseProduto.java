package br.net.luana.sistemaPedidos.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ClasseProduto implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomeClasse;

    @ManyToMany
    @JoinTable(name = "CLASSE_PRODUTO_PERSONALIZACAO",
            joinColumns = @JoinColumn(name = "classe_produto_id"),
            inverseJoinColumns = @JoinColumn(name = "personalizacao_id"))
    private List<Personalizacao> personalizacoes = new ArrayList<>();

    @OneToMany (mappedBy = "classeProduto")
    private List<Referencia> referencias = new ArrayList<>();

    public ClasseProduto() {
    }

    public ClasseProduto(Integer id, String nomeClasse) {
        this.id = id;
        this.nomeClasse = nomeClasse;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public List<Personalizacao> getPersonalizacoes() {
        return personalizacoes;
    }

    public void setPersonalizacoes(List<Personalizacao> personalizacoes) {
        this.personalizacoes = personalizacoes;
    }

    public List<Referencia> getReferencias() {
        return referencias;
    }

    public void setReferencias(List<Referencia> referencias) {
        this.referencias = referencias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClasseProduto that = (ClasseProduto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
