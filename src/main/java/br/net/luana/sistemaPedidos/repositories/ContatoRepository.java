package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends MasterRepository<Contato, Integer> {
}
