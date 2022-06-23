package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.Produto;
import br.net.luana.sistemaPedidos.domain.Referencia;
import br.net.luana.sistemaPedidos.dto.ProdutoDTO;
import br.net.luana.sistemaPedidos.dto.ReferenciaDTO;
import br.net.luana.sistemaPedidos.service.ProdutoService;
import br.net.luana.sistemaPedidos.service.ReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoResourceImpl extends MasterResourceImpl<Produto, ProdutoDTO, Integer>
        implements ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    public ProdutoResourceImpl(ProdutoService produtoService) {
        super(produtoService);
    }

}
