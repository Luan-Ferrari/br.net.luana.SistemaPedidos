package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.Contato;
import br.net.luana.sistemaPedidos.domain.enums.TipoContato;
import org.springframework.stereotype.Component;

@Component
public class ContatoDTO extends MasterDTOImpl <Contato, ContatoDTO, Integer> {

    private String ddd;
    private String contato;
    private Integer tipoContato;

    public ContatoDTO() {
    }

    public ContatoDTO(Contato entity) {
        this.ddd = entity.getDdd();
        this.contato = entity.getContato();
        this.tipoContato = (entity.getTipoContato()==null) ? null : entity.getTipoContato().getId();
    }

    @Override
    public ContatoDTO makeDTO(Contato entity) {
        return new ContatoDTO(entity);
    }

    @Override
    public Contato makeEntityFromDTO(ContatoDTO dto) {
        Contato contato = new Contato();
        contato.setDdd(dto.getDdd());
        contato.setContato(dto.getContato());
        contato.setTipoContato(TipoContato.toEnum(dto.getTipoContato()));
        return contato;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Integer getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(Integer tipoContato) {
        this.tipoContato = tipoContato;
    }
}
