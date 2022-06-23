package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.TamanhosAceitos;
import br.net.luana.sistemaPedidos.repositories.OpcaoRepository;
import br.net.luana.sistemaPedidos.repositories.TamanhosAceitosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TamanhosAceitosServiceImpl extends MasterServiceImpl<TamanhosAceitos, Integer>
        implements TamanhosAceitosService {

    @Autowired
    TamanhosAceitosRepository tamanhosAceitosRepository;

    public TamanhosAceitosServiceImpl(TamanhosAceitosRepository tamanhosAceitosRepository) {
        super(tamanhosAceitosRepository);
    }


    @Override
    protected void updateData(TamanhosAceitos updateEntity, TamanhosAceitos entity) {

    }
}
