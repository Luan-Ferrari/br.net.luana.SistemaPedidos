package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Produto;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl extends MasterServiceImpl<Produto, Integer>
        implements ProdutoService {


    @Override
    protected void updateData(Produto updateEntity, Produto entity) {

    }
}
