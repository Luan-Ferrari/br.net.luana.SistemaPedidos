package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.Cliente;
import br.net.luana.sistemaPedidos.domain.Contato;
import br.net.luana.sistemaPedidos.domain.Endereco;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ClienteDTO extends MasterDTOImpl<Cliente, ClienteDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private ContatoDTO contatoDTO = new ContatoDTO();
    private EnderecoDTO enderecoDTO = new EnderecoDTO();

    private Integer id;

    @NotBlank(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    @Length(min = ValidationsValues.MIN, max = ValidationsValues.MAX_1, message = ValidationsValues.LENGTH)
    private String nome;

    private String sobrenome;

    private List<ContatoDTO> contatos = new ArrayList<>();

    private List<EnderecoDTO> enderecos = new ArrayList<>();

    private String cpf;

    private Date dataNascimento;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.sobrenome = entity.getSobrenome();
        this.contatos = contatoDTO.makeListDTO(entity.getContatos());
        this.enderecos = enderecoDTO.makeListDTO(entity.getEnderecos());
        this.cpf = entity.getCpf();
        this.dataNascimento = entity.getDataNascimento();
    }

    @Override
    public ClienteDTO makeDTO(Cliente entity) {
        return new ClienteDTO(entity);
    }

    @Override
    public Cliente makeEntityFromDTO(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNome(dto.getNome());
        cliente.setSobrenome(dto.getSobrenome());
        for (ContatoDTO contatoDTO : dto.getContatos()) {
            cliente.getContatos().add(contatoDTO.makeEntityFromDTO(contatoDTO));
        }
        for (EnderecoDTO enderecoDTO : dto.getEnderecos()) {
            cliente.getEnderecos().add(enderecoDTO.makeEntityFromDTO(enderecoDTO));
        }
        cliente.setCpf(dto.getCpf());
        cliente.setDataNascimento(dto.getDataNascimento());

        return cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public List<ContatoDTO> getContatos() {
        return contatos;
    }

    public void setContatos(List<ContatoDTO> contatos) {
        this.contatos = contatos;
    }

    public List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDTO> enderecos) {
        this.enderecos = enderecos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
