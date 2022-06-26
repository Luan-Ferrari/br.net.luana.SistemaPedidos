package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.TamanhosAceitos;
import br.net.luana.sistemaPedidos.dto.TamanhosAceitosDTO;
import br.net.luana.sistemaPedidos.service.TamanhosAceitosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tamanhosAceitos")
public class TamanhosAceitosResourceImpl extends MasterResourceAllEndpointsToUserImpl<TamanhosAceitos, TamanhosAceitosDTO, Integer>
        implements TamanhosAceitosResource {

    @Autowired
    private TamanhosAceitosService tamanhosAceitosService;

    public TamanhosAceitosResourceImpl(TamanhosAceitosService tamanhosAceitosService) {
        super(tamanhosAceitosService);
    }

}
