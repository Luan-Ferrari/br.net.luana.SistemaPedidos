package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.Colecao;
import br.net.luana.sistemaPedidos.dto.ColecaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ColecaoResource extends MasterResource<Colecao, ColecaoDTO, Integer> {

    @PatchMapping("/{entityId}/adicionar")
    ResponseEntity<Void> adicionar(@RequestBody ColecaoDTO entity, @PathVariable Integer entityId);

    @PatchMapping("/{entityId}/excluir")
    ResponseEntity<Void> excluir(@RequestBody ColecaoDTO entity, @PathVariable Integer entityId);

}
