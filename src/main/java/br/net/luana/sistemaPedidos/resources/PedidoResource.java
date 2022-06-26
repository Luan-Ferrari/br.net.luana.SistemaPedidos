package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.Pedido;
import br.net.luana.sistemaPedidos.dto.PedidoDTOCompleto;

public interface PedidoResource extends MasterResourceOnlyGetEndpointToUser<Pedido, PedidoDTOCompleto, Integer> {
}
