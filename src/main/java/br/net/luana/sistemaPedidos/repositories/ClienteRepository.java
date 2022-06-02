package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MasterRepository<Cliente, Integer> {
}
