package br.net.luana.sistemaPedidos.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Personalizacao implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomePersonalizacao;

    @ManyToMany
    @JoinTable(name = "PERSONALIZACAO_OPCAO",
            joinColumns = @JoinColumn(name = "personalizao_id"),
            inverseJoinColumns = @JoinColumn(name = "opcao_id"))
    private List<Opcao> opcoes = new ArrayList<>();

    @ManyToMany (mappedBy = "personalizacoes")
    private List<ClasseProduto> classesProduto = new ArrayList<>();

    public Personalizacao() {
    }

    public Personalizacao(Integer id, String nomePersonalizacao) {
        this.id = id;
        this.nomePersonalizacao = nomePersonalizacao;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomePersonalizacao() {
        return nomePersonalizacao;
    }

    public void setNomePersonalizacao(String nomePersonalizacao) {
        this.nomePersonalizacao = nomePersonalizacao;
    }

    public List<Opcao> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(List<Opcao> opcoes) {
        this.opcoes = opcoes;
    }

    public List<ClasseProduto> getClassesProduto() {
        return classesProduto;
    }

    public void setClassesProduto(List<ClasseProduto> classesProduto) {
        this.classesProduto = classesProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personalizacao that = (Personalizacao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
