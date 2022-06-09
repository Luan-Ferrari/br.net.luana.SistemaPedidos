package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.Colecao;
import br.net.luana.sistemaPedidos.domain.Cor;
import br.net.luana.sistemaPedidos.dto.ColecaoDTO;
import br.net.luana.sistemaPedidos.dto.CorDTO;
import br.net.luana.sistemaPedidos.service.ColecaoService;
import br.net.luana.sistemaPedidos.service.CorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cor")
public class CorResourceImpl extends MasterResourceImpl<Cor, CorDTO, Integer>
        implements CorResource {

    @Autowired
    private CorService corService;

    public CorResourceImpl(CorService corService) {
        super(corService);
    }

}
