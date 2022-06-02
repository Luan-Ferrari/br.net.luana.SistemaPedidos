package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.HistoricoStatusItem;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoStatusItemRepository extends MasterRepository<HistoricoStatusItem, Integer> {
}
