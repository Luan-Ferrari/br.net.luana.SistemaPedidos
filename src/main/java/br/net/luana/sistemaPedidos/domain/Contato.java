package br.net.luana.sistemaPedidos.domain;

import br.net.luana.sistemaPedidos.domain.enums.TipoContato;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Contato implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private String ddd;
    private String contato;
    private Integer tipoContato;

    public Contato() {
    }

    public Contato(Integer id, String ddd, String contato, TipoContato tipoContato) {
        this.id = id;
        this.ddd = ddd;
        this.contato = contato;
        this.tipoContato = (tipoContato == null) ? null : tipoContato.getCodigo();
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

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public TipoContato getTipoContato() {
        return TipoContato.toEnum(tipoContato);
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato.getCodigo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato1 = (Contato) o;
        return cliente.equals(contato1.cliente) && contato.equals(contato1.contato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, contato);
    }
}
