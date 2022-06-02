package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Colecao;
import org.springframework.stereotype.Service;

@Service
public class ColecaoServiceImpl extends MasterServiceImpl<Colecao, Integer>
        implements ColecaoService {


    @Override
    protected void updateData(Colecao updateEntity, Colecao entity) {

    }
}
