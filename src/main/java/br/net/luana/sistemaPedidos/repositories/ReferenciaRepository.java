package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.Referencia;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenciaRepository extends MasterRepository<Referencia, Integer> {
}
