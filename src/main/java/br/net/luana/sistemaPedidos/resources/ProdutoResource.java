package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.Produto;
import br.net.luana.sistemaPedidos.dto.ProdutoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProdutoResource extends MasterResourceAllEndpointsToUser<Produto, ProdutoDTO, Integer> {

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/lista/{tipoAtualizacao}")
    public abstract ResponseEntity<List<Integer>> updateList(@RequestBody List<ProdutoDTO> lista, @PathVariable String tipoAtualizacao);

}
