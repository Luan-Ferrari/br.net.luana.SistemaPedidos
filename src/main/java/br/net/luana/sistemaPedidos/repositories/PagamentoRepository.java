package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.Pagamento;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends MasterRepository<Pagamento, Integer>{
}
