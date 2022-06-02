package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.Pedido;
import br.net.luana.sistemaPedidos.domain.enums.StatusPedido;
import br.net.luana.sistemaPedidos.domain.enums.TipoPedido;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
public class PedidoDTOSemListas extends MasterDTOImpl<Pedido, PedidoDTOSemListas, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer tipoPedido;
    private LocalDate dataPedido;
    private LocalDate dataPrevisao;
    private LocalDate dataEntrega;
    private Integer statusPedido;

    private Integer pacote;

    public PedidoDTOSemListas() {
    }

    public PedidoDTOSemListas(Pedido entity) {
        this.id = entity.getId();
        this.tipoPedido = (entity.getTipoPedido() == null) ? null : entity.getTipoPedido().getCodigo();
        this.dataPedido = entity.getDataPedido();
        this.dataPrevisao = entity.getDataPrevisao();
        this.dataEntrega = entity.getDataEntrega();
        this.statusPedido = (entity.getStatusPedido() == null ? null : entity.getStatusPedido().getCodigo());
        this.pacote = entity.getPacote();
    }

    @Override
    public PedidoDTOSemListas makeDTO(Pedido entity) {
        return new PedidoDTOSemListas(entity);
    }

    @Override
    public Pedido makeEntityFromDTO(PedidoDTOSemListas dto) {
        Pedido pedido = new Pedido();
        pedido.setId(dto.getId());
        pedido.setTipoPedido(TipoPedido.toEnum(dto.getTipoPedido()));
        pedido.setDataPedido(dto.getDataPedido());
        pedido.setDataPrevisao(dto.getDataPrevisao());
        pedido.setDataEntrega(dto.getDataEntrega());
        pedido.setStatusPedido(StatusPedido.toEnum(dto.getStatusPedido()));
        pedido.setPacote(dto.getPacote());

        return pedido;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(Integer tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalDate getDataPrevisao() {
        return dataPrevisao;
    }

    public void setDataPrevisao(LocalDate dataPrevisao) {
        this.dataPrevisao = dataPrevisao;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Integer getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(Integer statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Integer getPacote() {
        return pacote;
    }

    public void setPacote(Integer pacote) {
        this.pacote = pacote;
    }

}
