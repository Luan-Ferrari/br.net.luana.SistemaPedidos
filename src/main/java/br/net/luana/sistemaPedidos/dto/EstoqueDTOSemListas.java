package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.Estoque;
import org.springframework.stereotype.Component;

@Component
public class EstoqueDTOSemListas extends MasterDTOImpl<Estoque, EstoqueDTOSemListas, Integer> {

    private Integer id;
    private String nomeEstoque;

    public EstoqueDTOSemListas() {
    }

    public EstoqueDTOSemListas(Estoque entity) {
        this.id = entity.getId();
        this.nomeEstoque = entity.getNomeEstoque();
    }

    @Override
    public EstoqueDTOSemListas makeDTO(Estoque entity) {
        return new EstoqueDTOSemListas(entity);
    }

    @Override
    public Estoque makeEntityFromDTO(EstoqueDTOSemListas dto) {
        Estoque estoque = new Estoque();
        estoque.setId(dto.getId());
        estoque.setNomeEstoque(dto.getNomeEstoque());

        return estoque;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeEstoque() {
        return nomeEstoque;
    }

    public void setNomeEstoque(String nomeEstoque) {
        this.nomeEstoque = nomeEstoque;
    }
}
