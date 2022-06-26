package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.ClasseProduto;
import br.net.luana.sistemaPedidos.domain.Personalizacao;
import br.net.luana.sistemaPedidos.dto.*;
import br.net.luana.sistemaPedidos.service.ClasseProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/classeProduto")
public class ClasseProdutoResourceImpl extends MasterResourceAllEndpointsToUserImpl<ClasseProduto, ClasseProdutoDTO, Integer>
        implements ClasseProdutoResource {

    @Autowired
    ClasseProdutoService classeProdutoService;

    private ReferenciaDTO referenciaDTO = new ReferenciaDTO();
    private PersonalizacaoDTO personalizacaoDTO = new PersonalizacaoDTO();

    public ClasseProdutoResourceImpl(ClasseProdutoService classeProdutoService) {
        super(classeProdutoService);
    }

    @Override
    public ResponseEntity<Void> adicionarPersonalizacoes(List<PersonalizacaoDTO> personalizacoes, Integer entityId) {
        List<Personalizacao> personalizacoes1 = new ArrayList<>();
        for (PersonalizacaoDTO personalizacaoDTO : personalizacoes) {
            personalizacoes1.add(personalizacaoDTO.makeEntityFromDTO(personalizacaoDTO));
        }
        classeProdutoService.adicionarPersonalizacao(entityId, personalizacoes1);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> excluirPersonalizacao(PersonalizacaoDTO personalizacao, Integer entityId) {
        classeProdutoService.excluirPersonalizacao(entityId, personalizacaoDTO.makeEntityFromDTO(personalizacao));
        return ResponseEntity.noContent().build();
    }
}
