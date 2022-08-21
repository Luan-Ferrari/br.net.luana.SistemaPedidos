package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.enums.*;
import br.net.luana.sistemaPedidos.dto.enums.*;
import br.net.luana.sistemaPedidos.service.MasterServiceToEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/enums")
public class MasterResourceToEnumsImpl implements MasterResourceToEnums {

    @Autowired
    private MasterServiceToEnums masterServiceToEnums;

    @Override
    public ResponseEntity<List<FormaPagamentoDTO>> findAllFormaPagamento() {
        List<FormaPagamento> list = masterServiceToEnums.findAllFormaPagamento();
        List<FormaPagamentoDTO> listDto = new ArrayList<>();
        for(FormaPagamento formaPagamento : list) {
            listDto.add(new FormaPagamentoDTO(formaPagamento));
        }
        return ResponseEntity.ok().body(listDto);
    }

    @Override
    public ResponseEntity<List<PerfilDTO>> findAllPerfil() {
        List<Perfil> list = masterServiceToEnums.findAllPerfil();
        List<PerfilDTO> listDto = new ArrayList<>();
        for(Perfil perfil : list) {
            listDto.add(new PerfilDTO(perfil));
        }
        return ResponseEntity.ok().body(listDto);
    }

    @Override
    public ResponseEntity<List<StatusItemDTO>> findAllStatusItem() {
        List<StatusItem> list = masterServiceToEnums.findAllStatusItem();
        List<StatusItemDTO> listDto = new ArrayList<>();
        for(StatusItem statusItem : list) {
            listDto.add(new StatusItemDTO(statusItem));
        }
        return ResponseEntity.ok().body(listDto);
    }

    @Override
    public ResponseEntity<List<StatusPedidoDTO>> findAllStatusPedido() {
        List<StatusPedido> list = masterServiceToEnums.findAllStatusPedido();
        List<StatusPedidoDTO> listDto = new ArrayList<>();
        for(StatusPedido statusPedido : list) {
            listDto.add(new StatusPedidoDTO(statusPedido));
        }
        return ResponseEntity.ok().body(listDto);
    }

    @Override
    public ResponseEntity<List<StatusProdutoDTO>> findAllStatusProduto() {
        List<StatusProduto> list = masterServiceToEnums.findAllStatusProduto();
        List<StatusProdutoDTO> listDto = new ArrayList<>();
        for(StatusProduto statusProduto : list) {
            listDto.add(new StatusProdutoDTO(statusProduto));
        }
        return ResponseEntity.ok().body(listDto);
    }

    @Override
    public ResponseEntity<List<TamanhoDTO>> findAllTamanho() {
        List<Tamanho> list = masterServiceToEnums.findAllTamanho();
        List<TamanhoDTO> listDto = new ArrayList<>();
        for(Tamanho tamanho : list) {
            listDto.add(new TamanhoDTO(tamanho));
        }
        return ResponseEntity.ok().body(listDto);
    }

    @Override
    public ResponseEntity<List<TipoContatoDTO>> findAllTipoContato() {
        List<TipoContato> list = masterServiceToEnums.findAllTipoContato();
        List<TipoContatoDTO> listDto = new ArrayList<>();
        for(TipoContato tipoContato : list) {
            listDto.add(new TipoContatoDTO(tipoContato));
        }
        return ResponseEntity.ok().body(listDto);
    }

    @Override
    public ResponseEntity<List<TipoPedidoDTO>> findAllTipoPedido() {
        List<TipoPedido> list = masterServiceToEnums.findAllTipoPedido();
        List<TipoPedidoDTO> listDto = new ArrayList<>();
        for(TipoPedido tipoPedido : list) {
            listDto.add(new TipoPedidoDTO(tipoPedido));
        }
        return ResponseEntity.ok().body(listDto);
    }
}
