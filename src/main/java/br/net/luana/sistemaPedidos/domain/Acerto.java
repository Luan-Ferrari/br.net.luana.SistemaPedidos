package br.net.luana.sistemaPedidos.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Acerto implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Cliente cliente;

    private LocalDateTime dataAcerto;

    private LocalDate dataInicialPagamentos;

    private Double valorPago;

    private Double valorDevolvido;

    public Acerto() {
    }

    public Acerto(Integer id, Cliente cliente, LocalDateTime dataAcerto, LocalDate dataInicialPagamentos,
                  Double valorPago, Double valorDevolvido) {
        this.id = id;
        this.cliente = cliente;
        this.dataAcerto = dataAcerto;
        this.dataInicialPagamentos = dataInicialPagamentos;
        this.valorPago = valorPago;
        this.valorDevolvido = valorDevolvido;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataAcerto() {
        return dataAcerto;
    }

    public void setDataAcerto(LocalDateTime dataAcerto) {
        this.dataAcerto = dataAcerto;
    }

    public LocalDate getDataInicialPagamentos() {
        return dataInicialPagamentos;
    }

    public void setDataInicialPagamentos(LocalDate dataInicialPagamentos) {
        this.dataInicialPagamentos = dataInicialPagamentos;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Double getValorDevolvido() {
        return valorDevolvido;
    }

    public void setValorDevolvido(Double valorDevolvido) {
        this.valorDevolvido = valorDevolvido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acerto acerto = (Acerto) o;
        return Objects.equals(id, acerto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
