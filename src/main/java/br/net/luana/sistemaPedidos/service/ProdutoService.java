package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Produto;

import java.util.List;

public interface ProdutoService extends MasterService<Produto, Integer> {

    public Produto findProdutoAtivoPorCodigo(Integer codigo);

    public List<Integer> atualizarLista(List<Produto> lista, String tipoAtualizacao);
}
