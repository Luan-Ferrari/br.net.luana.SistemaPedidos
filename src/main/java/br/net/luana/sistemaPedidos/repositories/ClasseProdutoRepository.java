package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.ClasseProduto;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseProdutoRepository extends MasterRepository<ClasseProduto, Integer> {
}
