package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Cor;
import org.springframework.stereotype.Service;

@Service
public class CorServiceImpl extends MasterServiceImpl<Cor, Integer>
        implements CorService {


    @Override
    protected void updateData(Cor updateEntity, Cor entity) {

    }
}
