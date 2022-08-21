package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.HistoricoStatusItem;
import br.net.luana.sistemaPedidos.domain.enums.StatusItem;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class HistoricoStatusItemDTO extends MasterDTOImpl<HistoricoStatusItem, HistoricoStatusItemDTO, Integer> {

    private Integer id;

    private ItemDTO item;

    private LocalDateTime dataHoraStatusAnterior;
    private Integer statusAnterior;

    private LocalDateTime dataHoraStatusAtual;
    private Integer statusAtual;

    private String motivo;

    public HistoricoStatusItemDTO() {
    }

    public HistoricoStatusItemDTO(HistoricoStatusItem entity) {
        this.id = entity.getId();
        this.item = item.makeDTO(entity.getItem());
        this.dataHoraStatusAnterior = entity.getDataHoraStatusAnterior();
        this.statusAnterior = (entity.getStatusAnterior() == null) ? null : entity.getStatusAnterior().getId();
        this.dataHoraStatusAtual = entity.getDataHoraStatusAtual();
        this.statusAtual = (entity.getStatusAtual() == null) ? null : entity.getStatusAtual().getId();
        this.motivo = entity.getMotivo();
    }

    @Override
    public HistoricoStatusItemDTO makeDTO(HistoricoStatusItem entity) {
        return new HistoricoStatusItemDTO(entity);
    }

    @Override
    public HistoricoStatusItem makeEntityFromDTO(HistoricoStatusItemDTO dto) {
        HistoricoStatusItem historicoStatusItem = new HistoricoStatusItem();
        historicoStatusItem.setId(dto.getId());
        historicoStatusItem.setItem(item.makeEntityFromDTO(dto.getItem()));
        historicoStatusItem.setDataHoraStatusAnterior(dto.getDataHoraStatusAnterior());
        historicoStatusItem.setStatusAnterior(StatusItem.toEnum(dto.getStatusAnterior()));
        historicoStatusItem.setDataHoraStatusAtual(dto.getDataHoraStatusAtual());
        historicoStatusItem.setStatusAtual(StatusItem.toEnum(dto.getStatusAtual()));
        historicoStatusItem.setMotivo(dto.getMotivo());

        return historicoStatusItem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public LocalDateTime getDataHoraStatusAnterior() {
        return dataHoraStatusAnterior;
    }

    public void setDataHoraStatusAnterior(LocalDateTime dataHoraStatusAnterior) {
        this.dataHoraStatusAnterior = dataHoraStatusAnterior;
    }

    public Integer getStatusAnterior() {
        return statusAnterior;
    }

    public void setStatusAnterior(Integer statusAnterior) {
        this.statusAnterior = statusAnterior;
    }

    public LocalDateTime getDataHoraStatusAtual() {
        return dataHoraStatusAtual;
    }

    public void setDataHoraStatusAtual(LocalDateTime dataHoraStatusAtual) {
        this.dataHoraStatusAtual = dataHoraStatusAtual;
    }

    public Integer getStatusAtual() {
        return statusAtual;
    }

    public void setStatusAtual(Integer statusAtual) {
        this.statusAtual = statusAtual;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
