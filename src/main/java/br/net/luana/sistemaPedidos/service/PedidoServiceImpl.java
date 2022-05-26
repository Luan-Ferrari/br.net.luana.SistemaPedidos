package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Pedido;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl extends MasterServiceImpl<Pedido, Integer>
        implements PedidoService {


    @Override
    protected void updateData(Pedido updateEntity, Pedido entity) {

    }
}
