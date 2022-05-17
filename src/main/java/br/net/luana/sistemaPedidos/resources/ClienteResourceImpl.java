package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.Cliente;
import br.net.luana.sistemaPedidos.dto.ClienteDTO;
import br.net.luana.sistemaPedidos.service.ClienteService;
import br.net.luana.sistemaPedidos.service.MasterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteResourceImpl extends MasterResourceImpl<Cliente, ClienteDTO, Integer>
        implements ClienteResource {

    public ClienteResourceImpl(ClienteService clienteService) {
        super(clienteService);
    }
}
