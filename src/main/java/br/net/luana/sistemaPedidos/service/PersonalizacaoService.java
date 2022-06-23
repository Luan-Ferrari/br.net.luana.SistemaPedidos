package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Opcao;
import br.net.luana.sistemaPedidos.domain.Personalizacao;

import java.util.List;

public interface PersonalizacaoService extends MasterService<Personalizacao, Integer> {

    void adicionarOpcao(Integer personalizacaoId, List<Opcao> opcoes);

    void excluirOpcao(Integer personalizacaoId, Opcao opcao);
}
