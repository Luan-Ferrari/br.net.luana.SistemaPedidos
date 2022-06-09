package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.Opcao;
import org.springframework.stereotype.Component;

@Component
public class OpcaoDTO extends MasterDTOImpl<Opcao, OpcaoDTO, Integer> {

    private Integer id;
    private String opcao;
    private Boolean alteraPreco;
    private Double valorAlteracao;
    private String textoLivre;

    public OpcaoDTO() {
    }

    public OpcaoDTO(Opcao entity) {
        this.id = entity.getId();
        this.opcao = entity.getOpcao();
        this.alteraPreco = entity.getAlteraPreco();
        this.valorAlteracao = entity.getValorAlteracao();
        this.textoLivre = entity.getTextoLivre();
    }

    @Override
    public OpcaoDTO makeDTO(Opcao entity) {
        return new OpcaoDTO(entity);
    }

    @Override
    public Opcao makeEntityFromDTO(OpcaoDTO dto) {
        Opcao opcao = new Opcao();
        opcao.setId(dto.getId());
        opcao.setOpcao(dto.getOpcao());
        opcao.setAlteraPreco(dto.getAlteraPreco());
        opcao.setValorAlteracao(dto.getValorAlteracao());
        opcao.setTextoLivre(dto.getTextoLivre());
        return opcao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
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

    public String getTextoLivre() {
        return textoLivre;
    }

    public void setTextoLivre(String textoLivre) {
        this.textoLivre = textoLivre;
    }
}
