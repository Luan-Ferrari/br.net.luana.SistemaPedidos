package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.enums.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MasterServiceToEnumsImpl implements MasterServiceToEnums {

    @Override
    public List<FormaPagamento> findAllFormaPagamento() {
        List<FormaPagamento> lista = new ArrayList<>();
        for(FormaPagamento enums : FormaPagamento.values()) {
            lista.add(enums);
        }
        return lista;
    }

    @Override
    public List<Perfil> findAllPerfil() {
        List<Perfil> lista = new ArrayList<>();
        for(Perfil enums : Perfil.values()) {
            lista.add(enums);
        }
        return lista;
    }

    @Override
    public List<StatusItem> findAllStatusItem() {
        List<StatusItem> lista = new ArrayList<>();
        for(StatusItem enums : StatusItem.values()) {
            lista.add(enums);
        }
        return lista;
    }

    @Override
    public List<StatusPedido> findAllStatusPedido() {
        List<StatusPedido> lista = new ArrayList<>();
        for(StatusPedido enums : StatusPedido.values()) {
            lista.add(enums);
        }
        return lista;
    }

    @Override
    public List<StatusProduto> findAllStatusProduto() {
        List<StatusProduto> lista = new ArrayList<>();
        for(StatusProduto enums : StatusProduto.values()) {
            lista.add(enums);
        }
        return lista;
    }

    @Override
    public List<Tamanho> findAllTamanho() {
        List<Tamanho> lista = new ArrayList<>();
        for(Tamanho enums : Tamanho.values()) {
            lista.add(enums);
        }
        return lista;
    }

    @Override
    public List<TipoContato> findAllTipoContato() {
        List<TipoContato> lista = new ArrayList<>();
        for(TipoContato enums : TipoContato.values()) {
            lista.add(enums);
        }
        return lista;
    }

    @Override
    public List<TipoPedido> findAllTipoPedido() {
        List<TipoPedido> lista = new ArrayList<>();
        for(TipoPedido enums : TipoPedido.values()) {
            lista.add(enums);
        }
        return lista;
    }
}
