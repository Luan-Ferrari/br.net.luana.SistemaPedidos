package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.ClasseProduto;
import br.net.luana.sistemaPedidos.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ClasseProdutoResource extends MasterResourceOnlyGetEndpointToUser<ClasseProduto, ClasseProdutoDTO, Integer> {

    @PatchMapping("/{entityId}/adicionarPersonalizacao")
    ResponseEntity<Void> adicionarPersonalizacoes(@RequestBody List<PersonalizacaoDTO> personalizacoes,
                                   @PathVariable Integer entityId);

    @PatchMapping("/{entityId}/excluirPersonalizacao")
    ResponseEntity<Void> excluirPersonalizacao(@RequestBody PersonalizacaoDTO personalizacao,
                                               @PathVariable Integer entityId);

}
