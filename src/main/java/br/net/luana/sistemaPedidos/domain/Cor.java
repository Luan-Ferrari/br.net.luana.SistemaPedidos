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

    private Boolean disponivel;

    @OneToMany(mappedBy = "idPK.cor")
    private List<ColecaoCor> itensCores = new ArrayList<>();

    public Cor() {
    }

    public Cor(Integer id, Boolean disponivel) {
        this.id = id;
        this.disponivel = disponivel;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<ColecaoCor> getItensCores() {
        return itensCores;
    }

    public void setItensCores(List<ColecaoCor> itensCores) {
        this.itensCores = itensCores;
    }

    public List<Colecao> getColecoes() {
        List<Colecao> lista = new ArrayList<>();
        for(ColecaoCor x : itensCores) {
            lista.add(x.getColecao());
        }
        return lista;
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
