package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.Produto;
import br.net.luana.sistemaPedidos.dto.ProdutoDTO;

public interface ProdutoResource extends MasterResourceOnlyGetEndpointToUser<Produto, ProdutoDTO, Integer> {


}
