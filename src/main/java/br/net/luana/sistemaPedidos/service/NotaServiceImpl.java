package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Nota;
import org.springframework.stereotype.Service;

@Service
public class NotaServiceImpl extends MasterServiceImpl<Nota, Integer>
        implements NotaService {


    @Override
    protected boolean updateData(Nota updateEntity, Nota entity) {
        return false;
    }
}
