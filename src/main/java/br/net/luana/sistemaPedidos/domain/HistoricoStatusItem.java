package br.net.luana.sistemaPedidos.domain;

import br.net.luana.sistemaPedidos.domain.enums.StatusItem;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class HistoricoStatusItem implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private LocalDateTime dataHoraStatusAnterior;
    private Integer statusAnterior;

    private LocalDateTime dataHoraStatusAtual;
    private Integer statusAtual;

    private String motivo;

    public HistoricoStatusItem() {
    }

    public HistoricoStatusItem(Integer id, Item item, LocalDateTime dataHoraStatusAnterior,
                               StatusItem statusAnterior, LocalDateTime dataHoraStatusAtual,
                               StatusItem statusAtual, String motivo) {
        this.id = id;
        this.item = item;
        this.dataHoraStatusAnterior = dataHoraStatusAnterior;
        this.statusAnterior = (statusAnterior == null) ? null : statusAnterior.getCodigo();
        this.dataHoraStatusAtual = dataHoraStatusAtual;
        this.statusAtual = (statusAtual == null) ? null : statusAtual.getCodigo();
        this.motivo = motivo;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LocalDateTime getDataHoraStatusAnterior() {
        return dataHoraStatusAnterior;
    }

    public void setDataHoraStatusAnterior(LocalDateTime dataHoraStatusAnterior) {
        this.dataHoraStatusAnterior = dataHoraStatusAnterior;
    }

    public StatusItem getStatusAnterior() {
        return StatusItem.toEnum(statusAnterior);
    }

    public void setStatusAnterior(StatusItem statusAnterior) {
        this.statusAnterior = (statusAnterior == null) ? null : statusAnterior.getCodigo();
    }

    public LocalDateTime getDataHoraStatusAtual() {
        return dataHoraStatusAtual;
    }

    public void setDataHoraStatusAtual(LocalDateTime dataHoraStatusAtual) {
        this.dataHoraStatusAtual = dataHoraStatusAtual;
    }

    public StatusItem getStatusAtual() {
        return StatusItem.toEnum(statusAtual);
    }

    public void setStatusAtual(StatusItem statusAtual) {
        this.statusAtual = (statusAtual == null) ? null : statusAtual.getCodigo();
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricoStatusItem that = (HistoricoStatusItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
