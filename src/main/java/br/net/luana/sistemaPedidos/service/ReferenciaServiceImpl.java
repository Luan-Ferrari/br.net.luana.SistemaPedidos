package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Referencia;
import br.net.luana.sistemaPedidos.repositories.OpcaoRepository;
import br.net.luana.sistemaPedidos.repositories.ReferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferenciaServiceImpl extends MasterServiceImpl<Referencia, Integer>
        implements ReferenciaService {

    @Autowired
    ReferenciaRepository referenciaRepository;

    public ReferenciaServiceImpl(ReferenciaRepository referenciaRepository) {super(referenciaRepository);}


    @Override
    protected boolean updateData(Referencia updateEntity, Referencia entity) {
        return false;
    }
}
