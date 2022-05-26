package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Endereco;
import br.net.luana.sistemaPedidos.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EnderecoServiceImpl extends MasterServiceImpl<Endereco, Integer>
        implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) { super(enderecoRepository);}

    @Override
    protected void updateData(Endereco updateEntity, Endereco entity) {

    }
}
