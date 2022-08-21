package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Usuario;
import br.net.luana.sistemaPedidos.repositories.UsuarioRepository;
import br.net.luana.sistemaPedidos.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNomeUsuario(username);
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserSS(usuario.getId(), usuario.getNomeUsuario(), usuario.getSenha(),
                usuario.getNome(), usuario.getSobrenome(), usuario.getPerfis());
    }
}
