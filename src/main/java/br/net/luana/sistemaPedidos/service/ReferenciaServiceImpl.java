package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Referencia;
import org.springframework.stereotype.Service;

@Service
public class ReferenciaServiceImpl extends MasterServiceImpl<Referencia, Integer>
        implements ReferenciaService {


    @Override
    protected void updateData(Referencia updateEntity, Referencia entity) {

    }
}
