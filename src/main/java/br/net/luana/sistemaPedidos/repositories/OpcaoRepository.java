package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.Opcao;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcaoRepository extends MasterRepository<Opcao, Integer> {
}
