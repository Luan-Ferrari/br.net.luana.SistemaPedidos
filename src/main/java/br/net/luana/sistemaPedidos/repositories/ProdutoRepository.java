package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.Produto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MasterRepository<Produto, Integer> {
}
