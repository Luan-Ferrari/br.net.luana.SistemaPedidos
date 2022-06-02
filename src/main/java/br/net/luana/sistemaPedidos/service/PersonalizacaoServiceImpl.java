package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Personalizacao;
import org.springframework.stereotype.Service;

@Service
public class PersonalizacaoServiceImpl extends MasterServiceImpl<Personalizacao, Integer>
        implements PersonalizacaoService {


    @Override
    protected void updateData(Personalizacao updateEntity, Personalizacao entity) {

    }
}
