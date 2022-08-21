package br.net.luana.sistemaPedidos.security;

import br.net.luana.sistemaPedidos.domain.enums.Perfil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserSS implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nomeUsuario;
    private String senha;
    private String nome;
    private String sobrenome;
    private Collection<? extends GrantedAuthority> authorities;

    public UserSS() {
    }

    public UserSS(Integer id, String nomeUsuario, String senha, String nome, String sobrenome,
                  Set<Perfil> perfis) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.authorities = perfis.stream()
                .map(x -> new SimpleGrantedAuthority(x.getDescricao()))
                .collect(Collectors.toSet());
    }

    public boolean hasRole(Perfil perfil) {
        return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getDescricao()));
    }

    public Integer getId() {
        return id;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return nomeUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
