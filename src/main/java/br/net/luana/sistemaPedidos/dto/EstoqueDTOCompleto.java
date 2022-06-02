package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.Estoque;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EstoqueDTOCompleto extends MasterDTOImpl<Estoque, EstoqueDTOCompleto, Integer> {

    private ItemDTO itemDTO = new ItemDTO();

    private Integer id;
    private String nomeEstoque;

    private List<ItemDTO> itens = new ArrayList<>();

    public EstoqueDTOCompleto() {
    }

    public EstoqueDTOCompleto(Estoque entity) {
        this.id = entity.getId();
        this.nomeEstoque = entity.getNomeEstoque();
        this.itens = itemDTO.makeListDTO(entity.getItens());
    }

    @Override
    public EstoqueDTOCompleto makeDTO(Estoque entity) {
        return new EstoqueDTOCompleto(entity);
    }

    @Override
    public Estoque makeEntityFromDTO(EstoqueDTOCompleto dto) {
        Estoque estoque = new Estoque();
        estoque.setId(dto.getId());
        estoque.setNomeEstoque(dto.getNomeEstoque());
        for (ItemDTO itemDTO : dto.getItens()) {
            estoque.getItens().add(itemDTO.makeEntityFromDTO(itemDTO));
        }
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

    public List<ItemDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemDTO> itens) {
        this.itens = itens;
    }
}
