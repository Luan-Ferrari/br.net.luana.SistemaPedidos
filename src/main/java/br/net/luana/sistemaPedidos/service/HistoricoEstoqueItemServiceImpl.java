package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.HistoricoEstoqueItem;
import org.springframework.stereotype.Service;

@Service
public class HistoricoEstoqueItemServiceImpl extends MasterServiceImpl<HistoricoEstoqueItem, Integer>
        implements HistoricoEstoqueItemService {


    @Override
    protected boolean updateData(HistoricoEstoqueItem updateEntity, HistoricoEstoqueItem entity) {
        return false;
    }
}
