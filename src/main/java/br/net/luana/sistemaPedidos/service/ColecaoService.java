package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Colecao;
import br.net.luana.sistemaPedidos.domain.Cor;

import java.util.List;

public interface ColecaoService extends MasterService<Colecao, Integer> {

    List<Integer> verificaNumeracaoDuplicadaInsert (List<Integer> numeracoes);

    List<Integer> verificaNumeracaoDuplicadaUpdate (List<Integer> numeracoes,
                                                    List<Integer> numeracoesNovas);

    void adicionarItensColecao (Integer colecaoId, List<Cor> coresNovas,
                                List<Integer> numeracoesNovas);

    void excluirItensColecao (Integer colecaoId, List<Cor> coresExcluir);

}
