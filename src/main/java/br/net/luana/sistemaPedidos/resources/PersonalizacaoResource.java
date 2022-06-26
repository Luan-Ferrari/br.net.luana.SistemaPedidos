package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.Personalizacao;
import br.net.luana.sistemaPedidos.dto.OpcaoDTO;
import br.net.luana.sistemaPedidos.dto.PersonalizacaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PersonalizacaoResource extends MasterResourceOnlyGetEndpointToUser<Personalizacao, PersonalizacaoDTO, Integer> {

    @PatchMapping("/{entityId}/adicionarOpcao")
    ResponseEntity<Void> adicionarOpcoes(@RequestBody List<OpcaoDTO> opcoes,
                                        @PathVariable Integer entityId);

    @PatchMapping("/{entityId}/excluirOpcao")
    ResponseEntity<Void> excluirOpcao(@RequestBody OpcaoDTO opcao,
                                      @PathVariable Integer entityId);

}
