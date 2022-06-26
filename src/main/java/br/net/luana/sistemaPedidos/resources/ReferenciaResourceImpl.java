package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.Referencia;
import br.net.luana.sistemaPedidos.dto.ReferenciaDTO;
import br.net.luana.sistemaPedidos.service.ReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/referencia")
public class ReferenciaResourceImpl extends MasterResourceAllEndpointsToUserImpl<Referencia, ReferenciaDTO, Integer>
        implements ReferenciaResource {

    @Autowired
    private ReferenciaService referenciaService;

    public ReferenciaResourceImpl(ReferenciaService referenciaService) {
        super(referenciaService);
    }

}
