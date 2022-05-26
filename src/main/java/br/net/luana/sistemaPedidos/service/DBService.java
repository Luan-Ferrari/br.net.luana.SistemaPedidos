package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Cliente;
import br.net.luana.sistemaPedidos.domain.Contato;
import br.net.luana.sistemaPedidos.domain.Endereco;
import br.net.luana.sistemaPedidos.domain.enums.TipoContato;
import br.net.luana.sistemaPedidos.repositories.ClienteRepository;
import br.net.luana.sistemaPedidos.repositories.ContatoRepository;
import br.net.luana.sistemaPedidos.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@Transactional
@Service
public class DBService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public void instanciateTestDatabase() throws ParseException {

        //criando clientes
        Cliente cli1 = new Cliente(null, "Marisa", "da Barra", "123", LocalDate.of(1980, Month.JULY, 21));
        Cliente cli2 = new Cliente(null, "Joana", "Fonseca", null, null);
        Cliente cli3 = new Cliente(null, "Thiago", null, "345", null);

        //criando contatos
        Contato cont1 = new Contato(null, "54", "99988-7766", TipoContato.telefoneWhats);
        Contato cont2 = new Contato(null, null, "Marisa@gmail.com", TipoContato.email);
        Contato cont3 = new Contato(null, "55", "9977-5533", TipoContato.telefone);

        //criando enderecos
        Endereco end1 = new Endereco(null, "Rua da Barra", "25", null, "Centro", "Barra do Rio Azul");

        //associando clientes e contatos
        cont1.setCliente(cli1);
        cont2.setCliente(cli1);
        cont3.setCliente(cli2);

        //associando clientes e endereços
        end1.setCliente(cli1);

        //persistindo clientes
        clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));

        //persistindo contatos
        contatoRepository.saveAll(Arrays.asList(cont1, cont2, cont3));

        //persistindo enderecos
        enderecoRepository.saveAll(Arrays.asList(end1));
    }


}
