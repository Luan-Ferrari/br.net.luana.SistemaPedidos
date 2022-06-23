package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.Cliente;
import br.net.luana.sistemaPedidos.domain.Usuario;
import br.net.luana.sistemaPedidos.domain.enums.Perfil;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class UsuarioDTO extends MasterDTOImpl<Usuario, UsuarioDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private Integer id;

    @NotBlank(message = ValidationsValues.NOT_BLANK_OR_NOT_NULL_MESSAGE)
    @Length(min = ValidationsValues.MIN, max = ValidationsValues.MAX_1, message = ValidationsValues.LENGTH)
    private String nomeUsuario;

    private String senha;

    private Set<Integer> perfis = new HashSet<>();

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario entity) {
        this.id = entity.getId();
        this.nomeUsuario = entity.getNomeUsuario();
        this.perfis = entity.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
    }

    @Override
    public UsuarioDTO makeDTO(Usuario entity) {
        return new UsuarioDTO(entity);
    }

    @Override
    public Usuario makeEntityFromDTO(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNomeUsuario(dto.getNomeUsuario());
        usuario.setSenha(bCryptPasswordEncoder.encode(dto.getSenha()));

        return usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Integer> getPerfis() {
        return perfis;
    }

    public void setPerfis(Set<Integer> perfis) {
        this.perfis = perfis;
    }
}
