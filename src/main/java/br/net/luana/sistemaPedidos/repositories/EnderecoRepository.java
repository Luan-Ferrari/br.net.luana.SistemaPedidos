package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.Endereco;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends MasterRepository<Endereco, Integer> {
}
