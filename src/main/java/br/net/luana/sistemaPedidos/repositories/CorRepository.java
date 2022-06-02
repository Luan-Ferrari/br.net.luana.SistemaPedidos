package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.Cor;
import org.springframework.stereotype.Repository;

@Repository
public interface CorRepository extends MasterRepository<Cor, Integer> {
}
