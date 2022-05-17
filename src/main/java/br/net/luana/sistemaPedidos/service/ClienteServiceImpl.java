package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Cliente;
import br.net.luana.sistemaPedidos.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClienteServiceImpl extends MasterServiceImpl<Cliente, Integer>
        implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) { super(clienteRepository);}

    @Override
    protected void updateData(Cliente updateEntity, Cliente entity) {

    }
}
