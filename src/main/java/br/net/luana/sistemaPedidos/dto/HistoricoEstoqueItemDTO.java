package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.Estoque;
import br.net.luana.sistemaPedidos.domain.HistoricoEstoqueItem;
import br.net.luana.sistemaPedidos.domain.HistoricoStatusItem;
import br.net.luana.sistemaPedidos.domain.enums.StatusItem;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class HistoricoEstoqueItemDTO extends MasterDTOImpl<HistoricoEstoqueItem, HistoricoEstoqueItemDTO, Integer> {

    private Integer id;

    private ItemDTO item;

    private EstoqueDTOSemListas estoqueAnterior;
    private EstoqueDTOSemListas estoqueAtual;

    public HistoricoEstoqueItemDTO() {
    }

    public HistoricoEstoqueItemDTO(HistoricoEstoqueItem entity) {
        this.id = entity.getId();
        this.item = item.makeDTO(entity.getItem());
        this.estoqueAnterior = estoqueAnterior.makeDTO(entity.getEstoqueAnterior());
        this.estoqueAtual = estoqueAtual.makeDTO(entity.getEstoqueAtual());
    }

    @Override
    public HistoricoEstoqueItemDTO makeDTO(HistoricoEstoqueItem entity) {
        return new HistoricoEstoqueItemDTO(entity);
    }

    @Override
    public HistoricoEstoqueItem makeEntityFromDTO(HistoricoEstoqueItemDTO dto) {
        HistoricoEstoqueItem historicoEstoqueItem = new HistoricoEstoqueItem();
        historicoEstoqueItem.setId(dto.getId());
        historicoEstoqueItem.setItem(item.makeEntityFromDTO(dto.getItem()));
        historicoEstoqueItem.setEstoqueAnterior(estoqueAnterior.makeEntityFromDTO(dto.getEstoqueAnterior()));
        historicoEstoqueItem.setEstoqueAtual(estoqueAtual.makeEntityFromDTO(dto.getEstoqueAtual()));

        return historicoEstoqueItem;
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

    public EstoqueDTOSemListas getEstoqueAnterior() {
        return estoqueAnterior;
    }

    public void setEstoqueAnterior(EstoqueDTOSemListas estoqueAnterior) {
        this.estoqueAnterior = estoqueAnterior;
    }

    public EstoqueDTOSemListas getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(EstoqueDTOSemListas estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }
}
