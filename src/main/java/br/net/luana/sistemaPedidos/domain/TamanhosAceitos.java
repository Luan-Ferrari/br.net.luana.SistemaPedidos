package br.net.luana.sistemaPedidos.domain;

import br.net.luana.sistemaPedidos.domain.enums.Tamanho;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class TamanhosAceitos implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Tamanho tamanho;

    public TamanhosAceitos() {
    }

    public TamanhosAceitos(Integer id, Tamanho tamanho) {
        this.id = id;
        this.tamanho = tamanho;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TamanhosAceitos tamanhosAceitos = (TamanhosAceitos) o;
        return Objects.equals(id, tamanhosAceitos.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
