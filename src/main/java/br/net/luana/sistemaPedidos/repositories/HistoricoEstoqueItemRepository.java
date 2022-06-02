package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.HistoricoEstoqueItem;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoEstoqueItemRepository extends MasterRepository<HistoricoEstoqueItem, Integer> {
}
