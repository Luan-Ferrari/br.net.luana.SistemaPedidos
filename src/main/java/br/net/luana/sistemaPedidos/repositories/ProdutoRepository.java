package br.net.luana.sistemaPedidos.repositories;

import br.net.luana.sistemaPedidos.domain.Produto;
import br.net.luana.sistemaPedidos.domain.enums.StatusProduto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MasterRepository<Produto, Integer> {

    Produto findByCodigoProduto(Integer codigo);

    Produto findByCodigoProdutoAndStatusProduto(Integer codigo, Integer statusProduto);

}
