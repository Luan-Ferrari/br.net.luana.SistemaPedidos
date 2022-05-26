package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.Pedido;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends MasterRepository<Pedido, Integer>{
}
