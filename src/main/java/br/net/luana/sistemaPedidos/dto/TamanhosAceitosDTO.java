package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.TamanhosAceitos;
import br.net.luana.sistemaPedidos.domain.enums.Tamanho;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class TamanhosAceitosDTO extends MasterDTOImpl<TamanhosAceitos, TamanhosAceitosDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer tamanho;

    public TamanhosAceitosDTO() {
    }

    public TamanhosAceitosDTO(TamanhosAceitos entity) {
        this.id = entity.getId();
        this.tamanho = (entity.getTamanho() == null) ? null : entity.getTamanho().getCodigo();
    }

    @Override
    public TamanhosAceitosDTO makeDTO(TamanhosAceitos entity) {
        return new TamanhosAceitosDTO(entity);
    }

    @Override
    public TamanhosAceitos makeEntityFromDTO(TamanhosAceitosDTO dto) {
        TamanhosAceitos tamanhosAceitos = new TamanhosAceitos();
        tamanhosAceitos.setId(dto.getId());
        tamanhosAceitos.setTamanho(Tamanho.toEnum(dto.getTamanho()));

        return tamanhosAceitos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }
}
