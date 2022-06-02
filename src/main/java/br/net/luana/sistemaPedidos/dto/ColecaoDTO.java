package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.Colecao;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Component
public class ColecaoDTO extends MasterDTOImpl<Colecao, ColecaoDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private CorDTO corDTO = new CorDTO();

    private Integer id;
    private String nomeColecao;
    private List<CorDTO> cores = new ArrayList<>();

    public ColecaoDTO() {
    }

    public ColecaoDTO(Colecao entity) {
        this.id = entity.getId();
        this.nomeColecao = entity.getNomeColecao();
        this.cores = corDTO.makeListDTO(entity.getCores());
    }

    @Override
    public ColecaoDTO makeDTO(Colecao entity) {
        return new ColecaoDTO(entity);
    }

    @Override
    public Colecao makeEntityFromDTO(ColecaoDTO dto) {
        Colecao colecao = new Colecao();
        colecao.setId(dto.getId());
        colecao.setNomeColecao(dto.getNomeColecao());
        for (CorDTO corDTO : dto.getCores()) {
            colecao.getCores().add(corDTO.makeEntityFromDTO(corDTO));
        }
        return colecao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeColecao() {
        return nomeColecao;
    }

    public void setNomeColecao(String nomeColecao) {
        this.nomeColecao = nomeColecao;
    }

    public List<CorDTO> getCores() {
        return cores;
    }

    public void setCores(List<CorDTO> cores) {
        this.cores = cores;
    }
}
