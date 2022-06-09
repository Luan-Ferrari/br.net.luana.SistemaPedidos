package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Cliente;
import br.net.luana.sistemaPedidos.domain.Contato;
import br.net.luana.sistemaPedidos.domain.Endereco;
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
    @Autowired
    private ContatoService contatoService;
    @Autowired
    private EnderecoService enderecoService;

    public ClienteServiceImpl(ClienteRepository clienteRepository) { super(clienteRepository);}

    @Override
    public Cliente save(Cliente entity) {
        entity = clienteRepository.save(entity);
        for (Contato contato : entity.getContatos()) {
            contato.setCliente(entity);
            contatoService.save(contato);
        }
        for (Endereco endereco : entity.getEnderecos()) {
            endereco.setCliente(entity);
            enderecoService.save(endereco);
        }
        return entity;
    }

    @Override
    protected void updateData(Cliente updateEntity, Cliente entity) {

    }
}
