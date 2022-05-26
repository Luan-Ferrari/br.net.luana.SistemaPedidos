package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoDTO extends MasterDTOImpl<Endereco, EnderecoDTO, Integer> {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;

    public EnderecoDTO() {
    }

    public EnderecoDTO(Endereco entity) {
        this.logradouro = entity.getLogradouro();
        this.numero = entity.getNumero();
        this.complemento = entity.getComplemento();
        this.bairro = entity.getBairro();
        this.cidade = entity.getCidade();
    }

    @Override
    public EnderecoDTO makeDTO(Endereco entity) {
        return new EnderecoDTO(entity);
    }

    @Override
    public Endereco makeEntityFromDTO(EnderecoDTO dto) {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setNumero(dto.getNumero());
        endereco.setComplemento(dto.getComplemento());
        endereco.setBairro(dto.getBairro());
        endereco.setCidade(dto.getCidade());
        return endereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
