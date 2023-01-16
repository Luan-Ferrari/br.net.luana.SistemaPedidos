package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Opcao;
import br.net.luana.sistemaPedidos.repositories.OpcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpcaoServiceImpl extends MasterServiceImpl<Opcao, Integer>
        implements OpcaoService {

    @Autowired
    OpcaoRepository opcaoRepository;

    public OpcaoServiceImpl(OpcaoRepository opcaoRepository) {super(opcaoRepository);}

    @Override
    protected boolean updateData(Opcao updateEntity, Opcao entity) {
        return false;
    }
}
