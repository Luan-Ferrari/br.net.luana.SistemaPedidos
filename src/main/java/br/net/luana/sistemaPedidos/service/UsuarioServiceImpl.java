package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Usuario;
import br.net.luana.sistemaPedidos.domain.enums.Perfil;
import br.net.luana.sistemaPedidos.repositories.UsuarioRepository;
import br.net.luana.sistemaPedidos.security.UserSS;
import br.net.luana.sistemaPedidos.service.exceptions.AuthorizationException;
import br.net.luana.sistemaPedidos.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl extends MasterServiceImpl<Usuario, Integer>
        implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {super(usuarioRepository);}

    @Override
    public Usuario findById(Integer id) {
        UserSS user = authenticated();
        if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
            throw new AuthorizationException();
        }

        Optional<Usuario> obj = usuarioRepository.findById(id);

        return obj.orElseThrow(
                () -> new ObjectNotFoundException(id));
    }

    @Override
    public Usuario updateById(Usuario entity, Integer entityId) {
        Usuario updateEntity = findById(entityId);
        updateData(updateEntity, entity);
        return usuarioRepository.save(updateEntity);
    }

    public static UserSS authenticated() {
        try {
            return (UserSS) SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected void updateData(Usuario updateEntity, Usuario entity) {
        UserSS user = authenticated();
        if(entity.getSenha() != null ) {
            updateEntity.setSenha(entity.getSenha());
        }
        if (entity.getNomeUsuario() != null && user.hasRole(Perfil.ADMIN)) {
                updateEntity.setNomeUsuario(entity.getNomeUsuario());
        } else {
            throw new AuthorizationException();
        }
    }
}
