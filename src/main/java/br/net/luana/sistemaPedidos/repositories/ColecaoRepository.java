package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.Colecao;
import org.springframework.stereotype.Repository;

@Repository
public interface ColecaoRepository extends MasterRepository<Colecao, Integer> {
}
