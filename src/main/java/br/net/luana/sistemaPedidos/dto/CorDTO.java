package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.Cor;
import br.net.luana.sistemaPedidos.domain.Opcao;
import org.springframework.stereotype.Component;


@Component
public class CorDTO extends MasterDTOImpl<Cor, CorDTO, Integer> {

    private Integer id;
    private Boolean disponivel;

    public CorDTO() {
    }

    public CorDTO(Cor entity) {
        this.id = entity.getId();
        this.disponivel = entity.getDisponivel();
    }

    @Override
    public CorDTO makeDTO(Cor entity) {
        return new CorDTO(entity);
    }

    @Override
    public Cor makeEntityFromDTO(CorDTO dto) {
        Cor cor = new Cor();
        cor.setId(dto.getId());
        cor.setDisponivel(dto.getDisponivel());
        return cor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
}
