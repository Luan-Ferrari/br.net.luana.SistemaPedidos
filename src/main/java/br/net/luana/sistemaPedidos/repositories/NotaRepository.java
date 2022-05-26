package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.Nota;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends MasterRepository<Nota, Integer>{
}
