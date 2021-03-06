package br.net.luana.sistemaPedidos.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cliente implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String sobrenome;

    private Boolean precoAtacado;

    private Boolean condicional;

    @OneToMany(mappedBy = "cliente")
    private List<Contato> contatos = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    private String cpf;

    private LocalDate dataNascimento;

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String sobrenome,
                   Boolean precoAtacado, Boolean condicional,
                   String cpf, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.precoAtacado = precoAtacado;
        this.condicional = condicional;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Boolean getPrecoAtacado() {
        return precoAtacado;
    }

    public void setPrecoAtacado(Boolean precoAtacado) {
        this.precoAtacado = precoAtacado;
    }

    public Boolean getCondicional() {
        return condicional;
    }

    public void setCondicional(Boolean condicional) {
        this.condicional = condicional;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
