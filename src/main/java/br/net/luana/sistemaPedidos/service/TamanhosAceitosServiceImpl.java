package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.TamanhosAceitos;
import org.springframework.stereotype.Service;

@Service
public class TamanhosAceitosServiceImpl extends MasterServiceImpl<TamanhosAceitos, Integer>
        implements TamanhosAceitosService {


    @Override
    protected void updateData(TamanhosAceitos updateEntity, TamanhosAceitos entity) {

    }
}
