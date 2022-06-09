package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.Colecao;

import br.net.luana.sistemaPedidos.domain.ColecaoCor;
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
    private Integer anoColecao;

    private List<CorDTO> cores = new ArrayList<>();

    private List<Integer> numeros = new ArrayList<>();

    public ColecaoDTO() {
    }

    public ColecaoDTO(Colecao entity) {
        this.id = entity.getId();
        this.nomeColecao = entity.getNomeColecao();
        this.anoColecao = entity.getAnoColecao();
        this.cores = corDTO.makeListDTO(entity.getCores());
        this.numeros = entity.getNumeros();
    }

    @Override
    public ColecaoDTO makeDTO(Colecao entity) {
        return new ColecaoDTO(entity);
    }

    @Override
    public Colecao makeEntityFromDTO(ColecaoDTO dto) {
        try {
            Colecao colecao = new Colecao();
            colecao.setId(dto.getId());
            colecao.setNomeColecao(dto.getNomeColecao());
            colecao.setAnoColecao((dto.getAnoColecao()));
            for (int i = 0; i < cores.size(); i++) {
                ColecaoCor colecaoCor = new ColecaoCor(colecao,
                        corDTO.makeEntityFromDTO(cores.get(i)),
                        numeros.get(i));
                colecao.getItensCores().add(colecaoCor);
            }
            return colecao;
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException(cores.size() + " cores para "
                    + numeros.size() + " numeros");
        }
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

    public Integer getAnoColecao() {
        return anoColecao;
    }

    public void setAnoColecao(Integer anoColecao) {
        this.anoColecao = anoColecao;
    }

    public List<CorDTO> getCores() {
        return cores;
    }

    public void setCores(List<CorDTO> cores) {
        this.cores = cores;
    }

    public List<Integer> getNumeros() {
        return numeros;
    }

    public void setNumeros(List<Integer> numeros) {
        this.numeros = numeros;
    }
}
