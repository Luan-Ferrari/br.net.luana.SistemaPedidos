package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Nota;
import org.springframework.stereotype.Service;

@Service
public class NotaServiceImpl extends MasterServiceImpl<Nota, Integer>
        implements NotaService {


    @Override
    protected void updateData(Nota updateEntity, Nota entity) {

    }
}
