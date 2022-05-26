package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.Cliente;
import br.net.luana.sistemaPedidos.domain.Pedido;
import br.net.luana.sistemaPedidos.dto.ClienteDTO;
import br.net.luana.sistemaPedidos.dto.PedidoDTO;
import br.net.luana.sistemaPedidos.service.ClienteService;
import br.net.luana.sistemaPedidos.service.PedidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoResourceImpl extends MasterResourceImpl<Pedido, PedidoDTO, Integer>
        implements PedidoResource {

    public PedidoResourceImpl(PedidoService pedidoService) {
        super(pedidoService);
    }
}
