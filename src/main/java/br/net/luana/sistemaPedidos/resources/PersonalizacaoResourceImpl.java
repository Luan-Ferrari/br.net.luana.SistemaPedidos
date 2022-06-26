package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.Opcao;
import br.net.luana.sistemaPedidos.domain.Personalizacao;
import br.net.luana.sistemaPedidos.dto.OpcaoDTO;
import br.net.luana.sistemaPedidos.dto.PersonalizacaoDTO;
import br.net.luana.sistemaPedidos.service.PersonalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personalizacao")
public class PersonalizacaoResourceImpl extends MasterResourceAllEndpointsToUserImpl<Personalizacao, PersonalizacaoDTO, Integer>
        implements PersonalizacaoResource {

    @Autowired
    private PersonalizacaoService personalizacaoService;

    private OpcaoDTO opcaoDTO = new OpcaoDTO();

    public PersonalizacaoResourceImpl(PersonalizacaoService personalizacaoService) {
        super(personalizacaoService);
    }

    @Override
    public ResponseEntity<Void> adicionarOpcoes(List<OpcaoDTO> opcoes, Integer entityId) {
        List<Opcao> opcoes1 = new ArrayList<>();
        for (OpcaoDTO opcaoDTO : opcoes) {
            opcoes1.add(opcaoDTO.makeEntityFromDTO(opcaoDTO));
        }
        personalizacaoService.adicionarOpcao(entityId, opcoes1);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> excluirOpcao(OpcaoDTO opcao, Integer entityId) {
        personalizacaoService.excluirOpcao(entityId, opcaoDTO.makeEntityFromDTO(opcao));
        return ResponseEntity.noContent().build();
    }

}
