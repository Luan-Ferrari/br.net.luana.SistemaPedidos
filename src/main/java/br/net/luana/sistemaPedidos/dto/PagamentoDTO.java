package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.Pagamento;
import br.net.luana.sistemaPedidos.domain.enums.FormaPagamento;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
public class PagamentoDTO extends MasterDTOImpl<Pagamento, PagamentoDTO, Integer> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private LocalDate dataPagamento;
    private Integer formaPagamento;
    private Double valorPago;
    private Boolean pagamentoConcluido;

    public PagamentoDTO() {
    }

    public PagamentoDTO(Pagamento entity) {
        this.id = entity.getId();
        this.dataPagamento = entity.getDataPagamento();
        this.formaPagamento = (entity.getFormaPagamento() == null) ? null : entity.getFormaPagamento().getCodigo();
        this.valorPago = entity.getValorPago();
        this.pagamentoConcluido = entity.getPagamentoConcluido();
    }


    @Override
    public PagamentoDTO makeDTO(Pagamento entity) {
        return new PagamentoDTO(entity);
    }

    @Override
    public Pagamento makeEntityFromDTO(PagamentoDTO dto) {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(dto.getId());
        pagamento.setDataPagamento(dto.getDataPagamento());
        pagamento.setFormaPagamento(FormaPagamento.toEnum(dto.getFormaPagamento()));
        pagamento.setValorPago(dto.getValorPago());
        pagamento.setPagamentoConcluido(dto.pagamentoConcluido);
        return pagamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Integer getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Integer formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Boolean getPagamentoConcluido() {
        return pagamentoConcluido;
    }

    public void setPagamentoConcluido(Boolean pagamentoConcluido) {
        this.pagamentoConcluido = pagamentoConcluido;
    }
}
