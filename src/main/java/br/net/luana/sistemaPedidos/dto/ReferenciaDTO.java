package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.Referencia;
import org.springframework.stereotype.Component;


@Component
public class ReferenciaDTO extends MasterDTOImpl<Referencia, ReferenciaDTO, Integer> {

    private Integer id;
    private Integer codigo;
    private Boolean alteraPreco;
    private Double valorAlteracao;

    public ReferenciaDTO() {
    }

    public ReferenciaDTO(Referencia entity) {
        this.id = entity.getId();
        this.codigo = entity.getCodigo();
        this.alteraPreco = entity.getAlteraPreco();
        this.valorAlteracao = entity.getValorAlteracao();
    }

    @Override
    public ReferenciaDTO makeDTO(Referencia entity) {
        return new ReferenciaDTO(entity);
    }

    @Override
    public Referencia makeEntityFromDTO(ReferenciaDTO dto) {
        Referencia referencia = new Referencia();
        referencia.setId(dto.getId());
        referencia.setCodigo(dto.getCodigo());
        referencia.setAlteraPreco(dto.getAlteraPreco());
        referencia.setValorAlteracao(dto.getValorAlteracao());
        return referencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Boolean getAlteraPreco() {
        return alteraPreco;
    }

    public void setAlteraPreco(Boolean alteraPreco) {
        this.alteraPreco = alteraPreco;
    }

    public Double getValorAlteracao() {
        return valorAlteracao;
    }

    public void setValorAlteracao(Double valorAlteracao) {
        this.valorAlteracao = valorAlteracao;
    }
}
