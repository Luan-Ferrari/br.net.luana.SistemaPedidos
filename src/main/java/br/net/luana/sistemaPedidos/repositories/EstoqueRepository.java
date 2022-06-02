package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.Estoque;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends MasterRepository<Estoque, Integer> {
}
