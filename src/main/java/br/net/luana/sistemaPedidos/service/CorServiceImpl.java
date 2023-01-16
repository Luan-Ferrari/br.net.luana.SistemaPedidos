package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Cor;
import br.net.luana.sistemaPedidos.repositories.CorRepository;
import br.net.luana.sistemaPedidos.repositories.OpcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorServiceImpl extends MasterServiceImpl<Cor, Integer>
        implements CorService {

    @Autowired
    CorRepository corRepository;

    public CorServiceImpl(CorRepository corRepository) {super(corRepository);}




    @Override
    protected boolean updateData(Cor updateEntity, Cor entity) {
        return false;
    }
}
