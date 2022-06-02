package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Opcao;
import org.springframework.stereotype.Service;

@Service
public class OpcaoServiceImpl extends MasterServiceImpl<Opcao, Integer>
        implements OpcaoService {


    @Override
    protected void updateData(Opcao updateEntity, Opcao entity) {

    }
}
