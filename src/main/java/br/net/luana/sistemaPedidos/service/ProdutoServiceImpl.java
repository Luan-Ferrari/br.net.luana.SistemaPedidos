package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Produto;
import br.net.luana.sistemaPedidos.repositories.OpcaoRepository;
import br.net.luana.sistemaPedidos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl extends MasterServiceImpl<Produto, Integer>
        implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {super(produtoRepository);}


    @Override
    protected void updateData(Produto updateEntity, Produto entity) {

    }
}
