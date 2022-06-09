package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.ColecaoCor;
import br.net.luana.sistemaPedidos.domain.Cor;
import org.springframework.stereotype.Repository;

@Repository
public interface ColecaoCorRepository extends MasterRepository<ColecaoCor, Integer> {
}
