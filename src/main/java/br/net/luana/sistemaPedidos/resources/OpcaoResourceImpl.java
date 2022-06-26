package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.Opcao;
import br.net.luana.sistemaPedidos.dto.OpcaoDTO;
import br.net.luana.sistemaPedidos.service.OpcaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/opcao")
public class OpcaoResourceImpl extends MasterResourceAllEndpointsToUserImpl<Opcao, OpcaoDTO, Integer>
        implements OpcaoResource {

    @Autowired
    private OpcaoService opcaoService;

    public OpcaoResourceImpl(OpcaoService opcaoService) {
        super(opcaoService);
    }

}
