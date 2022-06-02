package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.Pedido;
import br.net.luana.sistemaPedidos.dto.PedidoDTOCompleto;
import br.net.luana.sistemaPedidos.service.PedidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoResourceImpl extends MasterResourceImpl<Pedido, PedidoDTOCompleto, Integer>
        implements PedidoResource {

    public PedidoResourceImpl(PedidoService pedidoService) {
        super(pedidoService);
    }
}
