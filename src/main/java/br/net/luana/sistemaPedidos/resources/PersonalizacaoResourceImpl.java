package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.Colecao;
import br.net.luana.sistemaPedidos.domain.Cor;
import br.net.luana.sistemaPedidos.domain.Personalizacao;
import br.net.luana.sistemaPedidos.dto.ColecaoDTO;
import br.net.luana.sistemaPedidos.dto.CorDTO;
import br.net.luana.sistemaPedidos.dto.OpcaoDTO;
import br.net.luana.sistemaPedidos.dto.PersonalizacaoDTO;
import br.net.luana.sistemaPedidos.service.ColecaoService;
import br.net.luana.sistemaPedidos.service.PersonalizacaoService;
import br.net.luana.sistemaPedidos.service.PersonalizacaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personalizacao")
public class PersonalizacaoResourceImpl extends MasterResourceImpl<Personalizacao, PersonalizacaoDTO, Integer>
        implements PersonalizacaoResource {

    @Autowired
    private PersonalizacaoService personalizacaoService;

    private OpcaoDTO opcaoDTO = new OpcaoDTO();

    public PersonalizacaoResourceImpl(PersonalizacaoService personalizacaoService) {
        super(personalizacaoService);
    }

}
