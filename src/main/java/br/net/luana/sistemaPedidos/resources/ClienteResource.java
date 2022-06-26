package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.Cliente;
import br.net.luana.sistemaPedidos.dto.ClienteDTO;

public interface ClienteResource extends MasterResourceOnlyGetEndpointToUser<Cliente, ClienteDTO, Integer> {
}
