package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.Nota;
import br.net.luana.sistemaPedidos.domain.Pedido;
import br.net.luana.sistemaPedidos.domain.enums.StatusPedido;
import br.net.luana.sistemaPedidos.domain.enums.TipoPedido;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoDTO extends MasterDTOImpl<Pedido, PedidoDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private NotaDTO notaDTO = new NotaDTO();
    private PagamentoDTO pagamentoDTO = new PagamentoDTO();

    private Integer id;

    private Integer tipoPedido;
    private LocalDate dataPedido;
    private LocalDate dataPrevisao;
    private LocalDate dataEntrega;
    private Integer statusPedido;

    private Integer pacote;

    private List<NotaDTO> notas = new ArrayList<>();
    private List<PagamentoDTO> pagamentos = new ArrayList<>();

    public PedidoDTO() {
    }

    public PedidoDTO(Pedido entity) {
        this.id = entity.getId();
        this.tipoPedido = (entity.getTipoPedido() == null) ? null : entity.getTipoPedido().getCodigo();
        this.dataPedido = entity.getDataPedido();
        this.dataPrevisao = entity.getDataPrevisao();
        this.dataEntrega = entity.getDataEntrega();
        this.statusPedido = (entity.getStatusPedido() == null ? null : entity.getStatusPedido().getCodigo());
        this.pacote = entity.getPacote();
        this.notas = notaDTO.makeListDTO(entity.getNotas());
        this.pagamentos = pagamentoDTO.makeListDTO(entity.getPagamentos());
    }

    @Override
    public PedidoDTO makeDTO(Pedido entity) {
        return new PedidoDTO(entity);
    }

    @Override
    public Pedido makeEntityFromDTO(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setId(dto.getId());
        pedido.setTipoPedido(TipoPedido.toEnum(dto.getTipoPedido()));
        pedido.setDataPedido(dto.getDataPedido());
        pedido.setDataPrevisao(dto.getDataPrevisao());
        pedido.setDataEntrega(dto.getDataEntrega());
        pedido.setStatusPedido(StatusPedido.toEnum(dto.getStatusPedido()));
        pedido.setPacote(dto.getPacote());
        for (NotaDTO notaDTO : dto.getNotas()) {
            pedido.getNotas().add(notaDTO.makeEntityFromDTO(notaDTO));
        }
        for (PagamentoDTO pagamentoDTO : dto.getPagamentos()) {
            pedido.getPagamentos().add(pagamentoDTO.makeEntityFromDTO(pagamentoDTO));
        }

        return pedido;
    }

    public NotaDTO getNotaDTO() {
        return notaDTO;
    }

    public void setNotaDTO(NotaDTO notaDTO) {
        this.notaDTO = notaDTO;
    }

    public PagamentoDTO getPagamentoDTO() {
        return pagamentoDTO;
    }

    public void setPagamentoDTO(PagamentoDTO pagamentoDTO) {
        this.pagamentoDTO = pagamentoDTO;
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

    public List<NotaDTO> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaDTO> notas) {
        this.notas = notas;
    }

    public List<PagamentoDTO> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<PagamentoDTO> pagamentos) {
        this.pagamentos = pagamentos;
    }
}
