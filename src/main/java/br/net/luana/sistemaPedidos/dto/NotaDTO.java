package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.Nota;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
public class NotaDTO extends MasterDTOImpl<Nota, NotaDTO, Integer> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer numeroNota;
    private LocalDate dataEmissao;

    public NotaDTO() {
    }

    public NotaDTO(Nota entity) {
        this.id = entity.getId();
        this.numeroNota = entity.getNumeroNota();
        this.dataEmissao = entity.getDataEmissao();
    }


    @Override
    public NotaDTO makeDTO(Nota entity) {
        return new NotaDTO(entity);
    }

    @Override
    public Nota makeEntityFromDTO(NotaDTO dto) {
        Nota nota = new Nota();
        nota.setId(dto.getId());
        nota.setNumeroNota(dto.getNumeroNota());
        nota.setDataEmissao(dto.getDataEmissao());

        return nota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(Integer numeroNota) {
        this.numeroNota = numeroNota;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
}
