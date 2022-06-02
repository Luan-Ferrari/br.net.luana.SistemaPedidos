package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.Personalizacao;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Component
public class PersonalizacaoDTO extends MasterDTOImpl<Personalizacao, PersonalizacaoDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private OpcaoDTO opcaoDTO = new OpcaoDTO();

    private Integer id;
    private String nomePersonalizacao;
    private List<OpcaoDTO> opcoes = new ArrayList<>();

    public PersonalizacaoDTO() {
    }

    public PersonalizacaoDTO(Personalizacao entity) {
        this.id = entity.getId();
        this.nomePersonalizacao = entity.getNomePersonalizacao();
        this.opcoes = opcaoDTO.makeListDTO(entity.getOpcoes());
    }

    @Override
    public PersonalizacaoDTO makeDTO(Personalizacao entity) {
        return new PersonalizacaoDTO(entity);
    }

    @Override
    public Personalizacao makeEntityFromDTO(PersonalizacaoDTO dto) {
        Personalizacao personalizacao = new Personalizacao();
        personalizacao.setId(dto.getId());
        personalizacao.setNomePersonalizacao(dto.getNomePersonalizacao());
        for (OpcaoDTO opcaoDTO : dto.getOpcoes()) {
            personalizacao.getOpcoes().add(opcaoDTO.makeEntityFromDTO(opcaoDTO));
        }
        return personalizacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomePersonalizacao() {
        return nomePersonalizacao;
    }

    public void setNomePersonalizacao(String nomePersonalizacao) {
        this.nomePersonalizacao = nomePersonalizacao;
    }

    public List<OpcaoDTO> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(List<OpcaoDTO> opcoes) {
        this.opcoes = opcoes;
    }
}
