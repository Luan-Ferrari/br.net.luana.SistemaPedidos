package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.ClasseProduto;
import br.net.luana.sistemaPedidos.domain.Personalizacao;

import java.util.List;

public interface ClasseProdutoService extends MasterService<ClasseProduto, Integer> {

    void adicionarPersonalizacao(Integer classeProdutoId, List<Personalizacao> personalizacoes);

    void excluirPersonalizacao(Integer classeProdutoId, Personalizacao personalizacao);
}
