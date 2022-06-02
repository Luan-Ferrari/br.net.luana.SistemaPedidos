package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Acerto;
import org.springframework.stereotype.Service;

@Service
public class AcertoServiceImpl extends MasterServiceImpl<Acerto, Integer>
        implements AcertoService {


    @Override
    protected void updateData(Acerto updateEntity, Acerto entity) {

    }
}
