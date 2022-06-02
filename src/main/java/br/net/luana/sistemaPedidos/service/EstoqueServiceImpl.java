package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Estoque;
import org.springframework.stereotype.Service;

@Service
public class EstoqueServiceImpl extends MasterServiceImpl<Estoque, Integer>
        implements EstoqueService {


    @Override
    protected void updateData(Estoque updateEntity, Estoque entity) {

    }
}
