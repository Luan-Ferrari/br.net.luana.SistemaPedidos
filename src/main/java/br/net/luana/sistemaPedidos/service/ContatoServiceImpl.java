package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Contato;
import br.net.luana.sistemaPedidos.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContatoServiceImpl extends MasterServiceImpl<Contato, Integer>
        implements ContatoService{

    @Autowired
    private ContatoRepository contatoRepository;

    @Override
    public Contato save(Contato entity) {
        if (entity.getId() == null) {
            contatoRepository.save(entity);
        } else {
            updateById(entity, entity.getId());
        }
        return entity;
    }

    public ContatoServiceImpl(ContatoRepository contatoRepository) { super (contatoRepository);}


    @Override
    protected void updateData(Contato updateEntity, Contato entity) {

    }
}
