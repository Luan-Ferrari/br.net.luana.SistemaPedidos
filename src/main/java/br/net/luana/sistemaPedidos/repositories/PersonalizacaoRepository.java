package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.Personalizacao;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalizacaoRepository extends MasterRepository<Personalizacao, Integer> {
}
