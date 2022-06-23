package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Usuario;
import br.net.luana.sistemaPedidos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends MasterServiceImpl<Usuario, Integer>
        implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {super(usuarioRepository);}

    @Override
    protected void updateData(Usuario updateEntity, Usuario entity) {

    }
}
