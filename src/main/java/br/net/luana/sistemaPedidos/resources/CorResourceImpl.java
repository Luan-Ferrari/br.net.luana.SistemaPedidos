package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.Cor;
import br.net.luana.sistemaPedidos.dto.CorDTO;
import br.net.luana.sistemaPedidos.service.CorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cor")
public class CorResourceImpl extends MasterResourceAllEndpointsToUserImpl<Cor, CorDTO, Integer>
        implements CorResource {

    @Autowired
    private CorService corService;

    public CorResourceImpl(CorService corService) {
        super(corService);
    }

}
