package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.Produto;
import br.net.luana.sistemaPedidos.dto.ProdutoDTO;
import br.net.luana.sistemaPedidos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/produto")
public class ProdutoResourceImpl extends MasterResourceAllEndpointsToUserImpl<Produto, ProdutoDTO, Integer>
        implements ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    public ProdutoResourceImpl(ProdutoService produtoService) {
        super(produtoService);
    }

}
