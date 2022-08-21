package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.enums.*;

import java.util.List;

public interface MasterServiceToEnums {

    List<FormaPagamento> findAllFormaPagamento();

    List<Perfil> findAllPerfil();

    List<StatusItem> findAllStatusItem();

    List<StatusPedido> findAllStatusPedido();

    List<StatusProduto> findAllStatusProduto();

    List<Tamanho> findAllTamanho();

    List<TipoContato> findAllTipoContato();

    List<TipoPedido> findAllTipoPedido();

}
