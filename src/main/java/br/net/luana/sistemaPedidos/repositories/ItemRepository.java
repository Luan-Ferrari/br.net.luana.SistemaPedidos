package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MasterRepository<Item, Integer> {
}
