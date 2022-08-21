package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.dto.enums.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface MasterResourceToEnums {

    @GetMapping("/formaPagamento")
    public abstract ResponseEntity<List<FormaPagamentoDTO>> findAllFormaPagamento();

    @GetMapping("/perfil")
    public abstract ResponseEntity<List<PerfilDTO>> findAllPerfil();

    @GetMapping("/statusItem")
    public abstract ResponseEntity<List<StatusItemDTO>> findAllStatusItem();

    @GetMapping("/statusPedido")
    public abstract ResponseEntity<List<StatusPedidoDTO>> findAllStatusPedido();

    @GetMapping("/statusProduto")
    public abstract ResponseEntity<List<StatusProdutoDTO>> findAllStatusProduto();

    @GetMapping("/tamanho")
    public abstract ResponseEntity<List<TamanhoDTO>> findAllTamanho();

    @GetMapping("/tipoContato")
    public abstract ResponseEntity<List<TipoContatoDTO>> findAllTipoContato();

    @GetMapping("/tipoPedido")
    public abstract ResponseEntity<List<TipoPedidoDTO>> findAllTipoPedido();
}
