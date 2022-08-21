package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.*;
import br.net.luana.sistemaPedidos.domain.enums.Perfil;
import br.net.luana.sistemaPedidos.domain.enums.StatusProduto;
import br.net.luana.sistemaPedidos.domain.enums.Tamanho;
import br.net.luana.sistemaPedidos.domain.enums.TipoContato;
import br.net.luana.sistemaPedidos.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
    private AcertoRepository acertoRepository;
    @Autowired
    private ClasseProdutoRepository classeProdutoRepository;
    @Autowired
    private ColecaoRepository colecaoRepository;
    @Autowired
    private CorRepository corRepository;
    @Autowired
    private EstoqueRepository estoqueRepository;
    @Autowired
    private HistoricoEstoqueItemRepository historicoEstoqueItemRepository;
    @Autowired
    private HistoricoStatusItemRepository historicoStatusItemRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private NotaRepository notaRepository;
    @Autowired
    private OpcaoRepository opcaoRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PersonalizacaoRepository personalizacaoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ReferenciaRepository referenciaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void instanciateTestDatabase() throws ParseException {

        //criando clientes
        Cliente cli1 = new Cliente(null, "Marisa", "da Barra", true, true, "123", LocalDate.of(1980, Month.JULY, 21));
        Cliente cli2 = new Cliente(null, "Joana", "Fonseca", false, false, null, null);
        Cliente cli3 = new Cliente(null, "Thiago", null, false, false,"345", null);

        //criando contatos
        Contato cont1 = new Contato(null, "54", "99988-7766", TipoContato.telefoneWhats);
        Contato cont2 = new Contato(null, null, "Marisa@gmail.com", TipoContato.email);
        Contato cont3 = new Contato(null, "55", "9977-5533", TipoContato.telefone);

        //criando enderecos
        Endereco end1 = new Endereco(null, "Rua da Barra", "25", null, "Centro", "Barra do Rio Azul");
        Endereco end2 = new Endereco(null, "Rua Pernambuco", "135", null, "Centro", "Erechim");

        //associando clientes e contatos
        cont1.setCliente(cli1);
        cont2.setCliente(cli1);
        cont3.setCliente(cli2);

        //associando clientes e endereços
        end1.setCliente(cli1);
        end2.setCliente(cli3);

        //criando cores
        Cor cor1 = new Cor(null, true);
        Cor cor2 = new Cor(null, true);
        Cor cor3 = new Cor(null, true);
        Cor cor4 = new Cor(null, false);
        Cor cor5 = new Cor(null, true);
        Cor cor6 = new Cor(null, true);
        Cor cor7 = new Cor(null, false);
        Cor cor8 = new Cor(null, true);
        Cor cor9 = new Cor(null, true);
        Cor cor10 = new Cor(null, true);
        Cor cor11 = new Cor(null, true);
        Cor cor12 = new Cor(null, true);
        Cor cor13 = new Cor(null, true);
        Cor cor14 = new Cor(null, true);
        Cor cor15 = new Cor(null, true);
        Cor cor16 = new Cor(null, true);
        Cor cor17 = new Cor(null, false);
        Cor cor18 = new Cor(null, true);
        Cor cor19 = new Cor(null, true);

        //criando colecoes
        Colecao col1 = new Colecao(null, "Viscose", 2022);
        Colecao col2 = new Colecao(null, "Lycra", 2022);
        Colecao col3 = new Colecao(null, "Soft", 2022);

        //associando cores a colecao


        //criando opcoes
        Opcao opcao1 = new Opcao(null, "Gola Redonda", false, 0.00, null);
        Opcao opcao2 = new Opcao(null, "Gola V", false, 0.00, null);
        Opcao opcao3 = new Opcao(null, "Gola Dois Botões", false, 0.00, null);
        Opcao opcao4 = new Opcao(null, "Mais Comprido", true, 10.00, null);
        Opcao opcao5 = new Opcao(null, "C/ Punho", false, 0.00, null);
        Opcao opcao6 = new Opcao(null, "S/ Punho", false, -2.00, null);
        Opcao opcao7 = new Opcao(null, "C/ Ziper", true, 5.00, null);
        Opcao opcao8 = new Opcao(null, "S/ Ziper", false, 0.00, null);

        //criando personalizacoes
        Personalizacao personal1 = new Personalizacao(null, "TipoGolea");
        Personalizacao personal2 = new Personalizacao(null, "Comprimento");
        Personalizacao personal3 = new Personalizacao(null, "Tipo Punho");
        Personalizacao personal4 = new Personalizacao(null, "Ziper");

        //associando opcoes e personalizacoes
        personal1.getOpcoes().addAll(Arrays.asList(opcao1, opcao2, opcao3));
        personal2.getOpcoes().addAll(Arrays.asList(opcao4));
        personal3.getOpcoes().addAll(Arrays.asList(opcao5, opcao6));
        personal4.getOpcoes().addAll(Arrays.asList(opcao7, opcao8));

        //criando referencias
        Referencia ref1 = new Referencia(null, 5101, false, 0.00);
        Referencia ref2 = new Referencia(null, 5102, false, 0.00);
        Referencia ref3 = new Referencia(null, 5103, false, 0.00);
        Referencia ref4 = new Referencia(null, 5104, false, 0.00);
        Referencia ref5 = new Referencia(null, 5105, false, 0.00);
        Referencia ref6 = new Referencia(null, 5106, false, 0.00);
        Referencia ref7 = new Referencia(null, 5801, true, 8.00);
        Referencia ref8 = new Referencia(null, 5802, false, 0.00);
        Referencia ref9 = new Referencia(null, 5803, false, 0.00);
        Referencia ref10 = new Referencia(null, 6101, true, 5.00);
        Referencia ref11 = new Referencia(null, 6201, false, 0.00);
        Referencia ref12 = new Referencia(null, 6301, true, 10.00);

        //criando classes produto
        ClasseProduto classeProduto1 = new ClasseProduto(null, "Pijama");
        ClasseProduto classeProduto2 = new ClasseProduto(null, "Roupão");
        ClasseProduto classeProduto3 = new ClasseProduto(null, "Calça");

        //associando referencia e classe produto
        ref1.setClasseProduto(classeProduto1);
        ref2.setClasseProduto(classeProduto1);
        ref3.setClasseProduto(classeProduto1);
        ref4.setClasseProduto(classeProduto1);
        ref5.setClasseProduto(classeProduto1);
        ref6.setClasseProduto(classeProduto1);
        ref7.setClasseProduto(classeProduto2);
        ref8.setClasseProduto(classeProduto2);
        ref9.setClasseProduto(classeProduto2);
        ref10.setClasseProduto(classeProduto3);
        ref11.setClasseProduto(classeProduto3);
        ref12.setClasseProduto(classeProduto3);

        //associando classe produto e personalizacao
        classeProduto1.getPersonalizacoes().addAll(Arrays.asList(personal1, personal2, personal3));
        classeProduto2.getPersonalizacoes().addAll(Arrays.asList(personal2));
        classeProduto3.getPersonalizacoes().addAll(Arrays.asList(personal2, personal3, personal4));


        //criando produtos
        Produto prod1 = new Produto(null, 1101, "conjunto lingerie", true, 20.00, 25.00, StatusProduto.ativo);
        Produto prod2 = new Produto(null, 3101, "calcinha", false, 40.00, 48.00, StatusProduto.ativo);
        Produto prod3 = new Produto(null, 3102, "pijama infantil", false, 50.00, 57.00, StatusProduto.ativo);
        Produto prod4 = new Produto(null, 3106, "pijama casaco", false, 50.00, 59.00, StatusProduto.ativo);
        Produto prod5 = new Produto(null, 2101, "moleton",false, 80.00, 92.00, StatusProduto.ativo);
        Produto prod6 = new Produto(null, 2102, "cueca", false, 70.00, 80.00, StatusProduto.ativo);
        Produto prod7 = new Produto(null, 1201, "lencol", false, 30.00, 38.00, StatusProduto.ativo);

        //associando produto e classe produto
        prod1.setClasseProduto(classeProduto1);
        prod2.setClasseProduto(classeProduto3);
        prod3.setClasseProduto(classeProduto3);
        prod4.setClasseProduto(classeProduto3);
        prod5.setClasseProduto(classeProduto2);
        prod6.setClasseProduto(classeProduto2);
        prod7.setClasseProduto(classeProduto1);

        //associando produtos e colecoes
        prod1.getColecoes().addAll(Arrays.asList(col1, col3));
        prod2.getColecoes().addAll(Arrays.asList(col1, col2, col3));
        prod3.getColecoes().addAll(Arrays.asList(col1, col2, col3));
        prod4.getColecoes().addAll(Arrays.asList(col1, col2, col3));
        prod5.getColecoes().addAll(Arrays.asList(col1, col3));
        prod6.getColecoes().addAll(Arrays.asList(col1, col3));
        prod7.getColecoes().addAll(Arrays.asList(col1, col3));

        //associando produtos e tamanhos
        prod1.getTamanhosAceitos().addAll(Arrays.asList(101, 102, 103));

        //criando usuarios
        Usuario usuario1 = new Usuario(null, "Luan",
                bCryptPasswordEncoder.encode("hakunaMatata"), "Luan", "Ferrari");
        Usuario usuario2 = new Usuario(null, "FabiSertao",
                bCryptPasswordEncoder.encode("sertao"), "Fabiana", "Casanova");
        Usuario usuario3 = new Usuario(null, "Tamiris",
                bCryptPasswordEncoder.encode("tami"), "Tamiris", "Vicentini");
        Usuario usuario4 = new Usuario(null, "ClienteQualquer",
                bCryptPasswordEncoder.encode("senhaQualquer"), "Cliente", "Qualquer");

        //criando administradores
        usuario1.addPerfil(Perfil.ADMIN);

        //persistindo clientes
        clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));

        //persistindo contatos
        contatoRepository.saveAll(Arrays.asList(cont1, cont2, cont3));

        //persistindo enderecos
        enderecoRepository.saveAll(Arrays.asList(end1));

        //persistindo cores
        corRepository.saveAll(Arrays.asList(cor1, cor2, cor3, cor4, cor5, cor6, cor7, cor8, cor9,
                cor10, cor11, cor12, cor13, cor14, cor15, cor16, cor17, cor18, cor19));

        //persistindo colecoes
        colecaoRepository.saveAll(Arrays.asList(col1, col2, col3));

        //persistindo opcoes
        opcaoRepository.saveAll(Arrays.asList(opcao1, opcao2, opcao3, opcao4, opcao5, opcao6,
                opcao7, opcao8));

        //persistindo personalizacoes
        personalizacaoRepository.saveAll(Arrays.asList(personal1, personal2, personal3, personal4));

        //persistindo referencia
        referenciaRepository.saveAll(Arrays.asList(ref1, ref2, ref3, ref4, ref5, ref6, ref7, ref8,
                ref9, ref10, ref11, ref12));

        //persistindo classe_produto
        classeProdutoRepository.saveAll(Arrays.asList(classeProduto1, classeProduto2, classeProduto3));

        //persistindo produtos
        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6, prod7));

        //persistindo usuarios
        usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3, usuario4));
    }


}
