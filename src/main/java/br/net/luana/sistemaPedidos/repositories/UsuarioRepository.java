package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioRepository extends MasterRepository<Usuario, Integer> {

    @Transactional(readOnly = true)
    Usuario findByNomeUsuario(String nomeUsuario);
}
