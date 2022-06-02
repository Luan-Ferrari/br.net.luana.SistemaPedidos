package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.Acerto;
import org.springframework.stereotype.Repository;

@Repository
public interface AcertoRepository extends MasterRepository<Acerto, Integer> {
}
