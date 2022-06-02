package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.Acerto;
import br.net.luana.sistemaPedidos.domain.Cliente;
import br.net.luana.sistemaPedidos.domain.Estoque;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class AcertoDTO extends MasterDTOImpl<Acerto, AcertoDTO, Integer> {

    private Integer id;
    private ClienteDTO cliente;
    private LocalDateTime dataAcerto;
    private LocalDate dataInicialPagamentos;
    private Double valorPago;
    private Double valorDevolvido;

    public AcertoDTO() {
    }

    public AcertoDTO(Acerto entity) {
        this.id = entity.getId();
        this.cliente = cliente.makeDTO(entity.getCliente());
        this.dataAcerto = entity.getDataAcerto();
        this.dataInicialPagamentos = entity.getDataInicialPagamentos();
        this.valorPago = entity.getValorPago();
        this.valorDevolvido = entity.getValorDevolvido();
    }

    @Override
    public AcertoDTO makeDTO(Acerto entity) {
        return new AcertoDTO(entity);
    }

    @Override
    public Acerto makeEntityFromDTO(AcertoDTO dto) {
        Acerto acerto = new Acerto();
        acerto.setId(dto.getId());
        acerto.setCliente(cliente.makeEntityFromDTO(dto.getCliente()));
        acerto.setDataAcerto(dto.getDataAcerto());
        acerto.setDataInicialPagamentos(dto.getDataInicialPagamentos());
        acerto.setValorPago(dto.getValorPago());
        acerto.setValorDevolvido(dto.getValorDevolvido());

        return acerto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
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
}
