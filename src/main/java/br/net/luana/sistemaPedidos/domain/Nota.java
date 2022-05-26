package br.net.luana.sistemaPedidos.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Nota implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numeroNota;

    private LocalDate dataEmissao;

    @ManyToMany(mappedBy = "notas")
    private List<Pedido> pedidos = new ArrayList<>();

    public Nota() {
    }

    public Nota(Integer id, Integer numeroNota, LocalDate dataEmissao) {
        this.id = id;
        this.numeroNota = numeroNota;
        this.dataEmissao = dataEmissao;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(Integer numeroNota) {
        this.numeroNota = numeroNota;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }


    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nota nota = (Nota) o;
        return Objects.equals(numeroNota, nota.numeroNota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroNota);
    }

}
