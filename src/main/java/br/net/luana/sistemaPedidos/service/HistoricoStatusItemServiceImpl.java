package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.HistoricoStatusItem;
import org.springframework.stereotype.Service;

@Service
public class HistoricoStatusItemServiceImpl extends MasterServiceImpl<HistoricoStatusItem, Integer>
        implements HistoricoStatusItemService {


    @Override
    protected void updateData(HistoricoStatusItem updateEntity, HistoricoStatusItem entity) {

    }
}
