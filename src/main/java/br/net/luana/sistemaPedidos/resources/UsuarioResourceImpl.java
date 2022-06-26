package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.Usuario;
import br.net.luana.sistemaPedidos.dto.UsuarioDTO;
import br.net.luana.sistemaPedidos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioResourceImpl extends MasterResourceGetAndPutEndpointsToUserImpl <Usuario,
        UsuarioDTO, Integer>
        implements UsuarioResource {

    @Autowired
    UsuarioService usuarioService;

    public UsuarioResourceImpl(UsuarioService usuarioService) {
        super(usuarioService);
    }

}
