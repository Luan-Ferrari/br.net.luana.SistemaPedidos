package br.net.luana.sistemaPedidos.service;

import java.util.Random;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        ClasseProduto classeProduto4 = new ClasseProduto(null, "Biquíni");
        ClasseProduto classeProduto5 = new ClasseProduto(null, "Lençois");
        ClasseProduto classeProduto6 = new ClasseProduto(null, "Moda Íntima");
        ClasseProduto classeProduto7 = new ClasseProduto(null, "Blusas");
        ClasseProduto classeProduto8 = new ClasseProduto(null, "Cereja Rosa");
        ClasseProduto classeProduto9 = new ClasseProduto(null, "Vestidos");


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

        String descricoes = "Conj. Enchimento Lycra, Renda ou Voal,Conj. Enchimento com Metal na Frente ou Alça Trançada ou Com Cinta Forrada,Conj. Enchimento Corpete ou Reforçado TAM 48, 50 e 52,Conj. Enchimento Aumentax,Sutiã Senhora S/ Bojo Cotton,Sutiã Senhora S/ Bojo Lycra/ Renda,Sutiã Senhora S/ Bojo Lycra/ Renda Reforçado,Sutiã Enchimento Lycra, Renda ou Voal,Sutiã Enchimento Metal na Frente/ Alça Trançada,Sutiã Corpete ou  Reforçado TAM. 48, 50 e 52,Sutiã Enchimento Cotton,Sutiã Enchimento Aumentax,Top S/ Bojo Cotton,Top S/ Bojo Suplex ou Lycra,Top Enchimento Suplex ou Lycra,Top Enchimento Suplex ou Lycra T48-50-52,Fio Lycra, Renda ou Voal (Todos os Modelos),Fio Cotton (Todos os Modelos),Fio C/ Piercing e Cós Duplo Largo ,Tanga Lycra, Renda, Mista ou Voal,Tanga Lycra/ Mista (Modelo com Pregas ou Senhora),Tanga Cotton,Tanga Cotton Senhora,Caleçon Lycra ou Renda,Caleçon Lycra (Modelo Comprido),Calçola Viscose,Calçola Lycra,Cueca Viscose,Cueca Viscose com Elástico,Cueca Boxer Lycra Viscolycra ou Cotton,Samba Canção,Sutiã Cortininha Simples Biquini,Sutiã Cortininha Simples C/ Babado Biquini,Sutiã Enchimento Todos os Modelos Biquini,Sutiã Enchimento Todos os Modelos Biquini TAM. 48, 50 ou 52 ,Sutiã Enchimento Todos os Modelos Biquini C/ Babado/ Bordados/ Mini Blusa,Sutiã Enchimento Todos os Modelos Biquini C/ Babado/ Bordados TAM. 48, 50 ou 52,Sutiã Enchimento Aumentax Biquini,Sutiã Sunquíni,Tanga Biquíni,Maio Liso,Maio Estampado,Maio Calção Liso,Maio Calção Estampado,Maio Enchimento,Básica Biquini Masculina e Feminina P-M,Básica Biquini Masculina e Feminina G-GG,Bermuda Curta Lycra e Liganete ,Bermuda Comprida ,Bermuda Forrada ,Calça Renda/Liganete,Vestido Liganete Tamanho Único,Vestido Rendão e/ou Aberto (Camisão),Vestido Longo ou Camisao Crepe,Saia curta (Canga),Saia Comprida (Canga) ,Sunga P-M-G,Sunga GG-XGG,Touca Adulto,Pijama Viscose, Apeluciado ou Cotton,Pijama Viscose  Apeluciado ou Cotton Casaco,Pijama Plush ou Soft,Pijama Plush ou Soft Casaco,Pijama Fleece Fechado,Pijama Fleece Casaco,Calça Minhocão,Camisa Minhocão,Calça Minhocão Térmica,Roupão Atoalhado,Roupão Plush / Soft / Fleece,Roupão Manga Curta Atoalhado,Pijama Curto 1/2 Manga Feminino ou Masculino,Pijama Corsário,Pijama Curto Liganete/ Cotton/ Vicoslycra,Pijama Bojo Duas Peças,Camisola de Bojo,Camisola Liganete C/ Babado Duplo,Camisola Regata,Camisola 1/2 Manga/ Manga Longa de Malha,Camisola 1/2 Manga Senhora ,Camisola Manga Longa Senhora Plush,Baby Doll Viscose e ou Baby Look,Baby Doll Lycra C/ Alcinha,Pijama Curto Aberto Feminino ou Masculino,Conjunto Abrigo Completo Feminino Jaqueta,Jaqueta Feminina Plush, Cotelê ou Moletom ,Colete Ziper/Botão/Pele,Blazer Tecido Grosso,Blazer Tecido Fino,Blusão Moletom Masculino,Jaqueta Masculina ,Colete Fechado Suplex ,Sobretudo,Sobretudo Soft,Casaco Fleece Forrado,Blusão S/ Capuz S/ Bordado Moletom,Blusão C/ Bordado C/ Pele C/ Matelasse C/ Capuz Moletom,Blusão S/ Capuz Fleece,Blusão C/ Capuz e Bolso Fleece,Calça ou Legging Plush ou Cotelê ou Moletom,Calça ou Legging Suplex C/ Zíper,Calça ou Legging Suplex,Calça Moletom Masculina,Calça Senhora Gorgurão,Corsário Suplex ,Bermuda Suplex ,Pantacourt,Bermuda Moleton Masculina,Bermuda Feminina Moletom/ Malha,Bermuda Senhora Gorgurão,Bermuda Tecido em Metro,Bermuda Tecido em Metro Masculina,Básica Canelada,Básica Manga Longa,Básica C/ Broderi/ Bordado,Básica Pele, Fleece ou Suplex ,Básica Térmica ou Plush,Blusa Matias,Cardigan Malha,Cardigan Tecido Grosso ,Blusa Verão,Blusa Verão Bordadas,Blusa Verão Crepe ou Crepe/malha,Blusa Verão Renda ou Camisa Rendão,Colan Malha,Colan Lycra ou Suplex,Regata Canelado, Viscolycra ou Liganete,Regata Canelado, Viscolycra ou Liganete Bordada,Regata Crepe,Sobrelegging Verão,Sobrelegging Plush/ Pele/ Fleece ,Camisa Feminina Plush ou Devorê ou Crepe ,Camiseta Masculina Manga Curta,Camiseta Masculina Manga Longa,Camiseta Masculina Gola Polo Manga Curta,Camiseta Masculina Gola Polo Manga Longa Malha,Camiseta Masculina Gola Polo Manga Longa Plush/ Termico,Vestido Fechado Tecido em Metro,Vestido Fechado Manga Curta,Vestido Aberto Manga Curta,Vestido Longo/ Macacão,Vestido Plush Manga Longa (Bordado + R$10,00),Vestido Canelado Manga Curta,Vestido Canelado Manga Longa,Saia Botão e Ziper,Saia Godê Suplex / Saia Longa Malha,Saia Cotelê ,Lençol Casal 4 Peças,Lençol Casal Avulso,Lençol Solteiro 3 Peças,Lençol Solteiro Avulso,Fronha,Blusa Cotton Light,Blusa Viscose Crepe,Blusa Viscose Crepe,Blusa TP Viscose Estampada,Blusa Viscose Crepe,Body Canelado de Viscose,Calça TP Viscose Linho,Calça Viscose Com Elastano,Vestido TP Viscose Linho,Vestido M.Malha Estampado,Blusa TP Viscose Linho Estampado,Blusa TP Viscose Com Elastano,Blusa TP Resort e Viscose Crepe,Blusa TP Resort e Viscose Crepe,Blusa TP Resort e Viscose Trabalhada,Blusa M.Malha,Blusa Viscose Trabalhada,Blusa TP Viscose Estampada,Shorts TP Viscose Linho,Calca TP Viscose Linho,Vestido Canelado de Viscose,Vestido TP Viscose Estampada,Pijama Apeluciados ou Viscose Bebê (1,2,3),Pijama Apeluciados ou Viscose Tam. 1 e 2 ,Pijama Apeluciados ou Viscose Tam. 4-6,Pijama Apeluciados ou Viscose Tam. 8-10,Pijama Apeluciados ou Viscose Tam. 12-14,Pijama Apeluciado ou Viscose CASACO Bebê (1,2,3),Pijama Apeluciado ou Viscose CASACO Tam. 1 e 2 ,Pijama Apeluciado ou Viscose CASACO Tam. 4-6,Pijama Apeluciado ou Viscose CASACO Tam. 8-10,Pijama Apeluciado ou Viscose CASACO Tam. 12-14,Pijama Plush ou Soft Bebê (1,2,3),Pijama Plush ou Soft Tam. 1 e 2 ,Pijama Plush ou Soft Tam. 4-6,Pijama Plush ou Soft Tam. 8-10,Pijama Plush ou Soft Tam. 12-14,Boris Bebê Plush ou Soft,TipTop Bebê Plush ou Soft,TipTop Tam. 2-4 e Bebê Dormir Plush ou Soft,Pijama Plush ou Soft CASACO ou ROUPÃO Bebê (1,2,3),Pijama Plush ou Soft CASACO ou ROUPÃO Tam. 1 e 2 ,Pijama Plush ou Soft CASACO ou ROUPÃO Tam. 4-6,Pijama Plush ou Soft CASACO ou ROUPÃO Tam. 8-10,Pijama Plush ou Soft CASACO ou ROUPÃO Tam. 12-14, Minhocão Calça Bebê (PP), Minhocão Calça Tam. 2 (P), Minhocão Calça Tam. 4-6 (M), Minhocão Calça Tam. 8-10 (G), Minhocão Calça Tam. 12-14 (GG),Boris Bebê e C/ colete ,TipTop, Pijamas Fleece Bebê (1,2,3), Pijamas Fleece Tam. 1 e 2 , Pijamas Fleece Tam. 4-6, Pijamas Fleece Tam. 8-10, Pijamas Fleece Tam. 12-14, Pijamas Fleece Boris Bebê, Pijamas Fleece TipTop Bebê, Pijamas Fleece TipTop Tam. 2-4 e Bebê Dormir, Pijamas Fleece CASACO ou ROUPÃO Bebê (1,2,3), Pijamas Fleece CASACO ou ROUPÃO Tam. 1 e 2 , Pijamas Fleece CASACO ou ROUPÃO Tam. 4-6, Pijamas Fleece CASACO ou ROUPÃO Tam. 8-10, Pijamas Fleece CASACO ou ROUPÃO Tam. 12-14, Pijamas Curtos Boris e Pij. Bebê, Pijamas Curtos Tam. 2, Pijamas Curtos Tam. 4-6, Pijamas Curtos Tam. 8-10, Pijamas Curtos Tam. 12-14,Camisola PP-P,Camisola M-G-GG,Baby Doll PP-P,Baby Doll M-G-GG,Conjunto Blusa Bebê (PP-P),Conjunto Blusa Tam. 2 (M),Conjunto Blusa Tam. 4-6 (G),Conjunto Blusa Tam. 8-10 (GG),Conjunto Blusa Tam. 12-14 (XGG),Conjunto Jaqueta Bebê (PP-P),Conjunto Jaqueta Tam. 2 (M),Conjunto Jaqueta Tam. 4-6 (G),Conjunto Jaqueta Tam. 8-10 (GG),Conjunto Jaqueta Tam. 12-14 (XGG),Conjunto Casaco Bebê, 1 e 2 Infantil (PP-P)                  ( 1-2-3 C/ Babado na frente,Conjunto Casaco Tam. 4-6 (M-G),Conjunto Casaco Tam. 8-10 (GG),Conjunto Casaco Tam. 12-14 (XGG),Blusa Bebê (PP-P),Blusa Tam. 2 (M),Blusa Tam. 4-6 (G),Blusa Tam. 8-10 (GG),Blusa Tam. 12-14 (XGG),Blusão Fleece Bebê e Tam.2,Blusão Fleece Tam.4-6,Blusão Fleece Tam.8-10,Blusão Fleece Tam. 12-14,Jaqueta Bebê (PP-P),Jaqueta Tam. 2 (M),Jaqueta Tam. 4-6 (G),Jaqueta Tam. 8-10 (GG),Jaqueta Tam. 12-14 (XGG),Jaqueta Fleece Bebê e Tam.2,Jaqueta Fleece Tam.4-6,Jaqueta Fleece Tam.8-10,Jaqueta Fleece Tam.12-14,Casaco Bebê, 1 e 2 Infantil (PP-P),Casaco Tam. 4-6 (M-G),Casaco Tam. 8-10 (GG),Casaco Tam. 12-14 (XGG),Casaco Fleece Bebê e Tam.2,Casaco Fleece Tam.4-6,Casaco Fleece Tam.8-10,Casaco Fleece Tam.12-14,Colete Bebê, 1 e 2 Infantil,Colete Tam 4-6-8,Colete Tam 10-12-14,Calças, Leggings e Bermudas Infantil,Calça ou Legging Bebê, 1 e 2 Infantil (PP-P),Calça ou Legging Tam. 4-6 (M-G),Calça ou Legging Tam. 8-10 (G),Calça ou Legging Tam. 12-14 (XGG),Bermuda Tam. 2,Bermuda Tam. 4-6,Bermuda Tam. 8-10,Bermuda Tam. 12-14,Básica Malha ou Canelada PP-P (Bebe (1,2,3) e 1-2 Inf),Básica Malha ou Canelada M (4-6),Básica Malha ou Canelada G (8-10),Básica Malha ou Canelada GG (12-14),Básica Plush PP-P (Bebe -2) ,Básica Plush M (4-6),Básica Plush G (8-10),Básica Plush GG (12-14),Camisa Masc. Manga Longa Malha Bebê e Tam. 2,Camisa Masc. Manga Longa Malha Tam. 4-6-8,Camisa Masc. Manga Longa Malha Tam. 10-12-14,Camisa Masc. Manga Longa Plush Bebê e Tam.2,Camisa Masc. Manga Longa Plush Tam. 4-6-8,Camisa Masc. Manga Longa Plush Tam. 10-12-14,Sutiã Top ou Bustier Cotton,Sutiã Enchimento Cotton,Sutiã Enchimento Lycra,Tanga Cotton PP-P-M,Tanga Cotton G-GG-XGG,Calcinha Viscose,Calcinha Cotton com Renda ,Cueca Viscose,Cueca Viscose com Elástico,Cueca Boxer Inf. PP-P-M,Cueca Boxer Inf. G-GG-XGG,Sutia Biquini Infantil Simples ,Sutia Biquini Infantil Enchimento,Sutia Biquini Infantil Enchimento C/ Babado,Tanga Biquini Inf., Bermuda Forrada P-M-G,Tanga Biquini Inf., Bermuda Forrada GG- XGG ou Com Babadao,Maio Infantil Liso ou Estampado P-M-G,Maio Inf. Liso Estampado GG-XGG,Básica Infantil Biquini  PP-P-M-G,Básica Infantil Biquini GG-XGG,Bermuda Biquini Inf. sem Forro P-M-G,Bermuda Biquini Inf. Sem Forro GG-XGG,Saia Inf., Saída de Praia P-M-G,Saia Inf. Saída de Praia GG-XGG,Sunga Infantil PP-P-M,Sunga Infantil G-GG-XGG,Touca Infantil";
        String codigos = "1101,1102,1103,1104,1110,1111,1112,1113,1114,1115,1116,1117,1121,1122,1123,1124,1131,1132,1133,1136,1137,1138,1139,1140,1141,1142,1143,1150,1151,1152,1153,2111,2112,2113,2114,2115,2116,2117,2118,2131,2141,2142,2143,2144,2145,2146,2147,2150,2151,2152,2153,2161,2162,2163,2171,2172,2181,2182,2199,4101,4102,4103,4104,4105,4106,4111,4112,4113,4121,4122,4123,4151,4152,4153,4154,4161,4162,4163,4164,4165,4166,4171,4172,4173,3101,3111,3112,3113,3114,3115,3116,3117,3121,3122,3123,3131,3132,3133,3134,3170,3171,3172,3173,3174,3181,3191,3192,3193,3194,3195,3196,3197,5101,5102,5103,5104,5105,5106,5107,5108,5111,5112,5113,5114,5115,5116,5121,5122,5123,5131,5132,5141,5161,5162,5171,5172,5173,6101,6110,6111,6112,6113,6121,6122,6151,6152,6153,7101,7102,7103,7104,7105,12005,12006,72576,72577,72599,72616,72620,72621,72631,72635,85282,85283,85284,85285,85286,85289,85293,85295,85298,85299,85301,85303,4201,4202,4203,4204,4205,4221,4222,4223,4224,4225,4211,4212,4213,4214,4215,4216,4217,4218,4231,4232,4233,4234,4235,4241,4242,4243,4244,4245,4246,4247,4251,4252,4253,4254,4255,4256,4257,4258,4261,4262,4263,4264,4265,4271,4272,4273,4274,4275,4276,4277,4278,4279,3201,3202,3203,3204,3205,3211,3212,3213,3214,3215,3221,3222,3223,3224,3231,3232,3233,3234,3235,3236,3237,3238,3239,3241,3242,3243,3244,3245,3246,3247,3248,3249,3251,3252,3253,3254,3255,3256,3257,3258,3261,3262,3263,3271,3272,3273,3274,3291,3292,3293,3294,5201,5202,5203,5204,5211,5212,5213,5214,5241,5242,5243,5251,5252,5253,1211,1212,1213,1221,1222,1223,1224,1231,1232,1233,1234,2211,2212,2213,2231,2232,2241,2242,2251,2252,2261,2262,2271,2272,2281,2282,2299";

        String[] listaDescricoes = descricoes.split(",");
        String[] listaCodigosStrings = codigos.split(",");

        System.out.println(listaCodigosStrings.length);
        System.out.println(listaDescricoes.length);

        Random gerador = new Random();

        for (int i = 0; i < listaCodigosStrings.length; i++) {
            Boolean conjunto = false;
            if (i % 10 == 0) {
                conjunto = true;
            } else {
                conjunto = false;
            }

            Boolean adulto = false;
            if (i % 4 == 0) {
                adulto = false;
            } else {
                conjunto = true;
            }


            Integer valor = gerador.nextInt(200) + 35;

            List<ClasseProduto> classes = new ArrayList<>();
            classes.addAll(Arrays.asList(classeProduto1, classeProduto2, classeProduto3, classeProduto4, classeProduto5,
                    classeProduto6, classeProduto7, classeProduto8, classeProduto9));

            Integer indiceClasse = gerador.nextInt(8) + 1;

            Produto produto = new Produto (null, Integer.parseInt(listaCodigosStrings[i]), listaDescricoes[i], conjunto, (double)valor, (double)valor - 20, StatusProduto.ativo, adulto);
            produto.setClasseProduto(classes.get(indiceClasse));

            produtoRepository.save(produto);
        }

//        criando produtos
//        Produto prod1 = new Produto(null, 1101, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod2 = new Produto(null, 3101, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod3 = new Produto(null, 3102, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod4 = new Produto(null, 3106, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod5 = new Produto(null, 2101, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod6 = new Produto(null, 2102, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod7 = new Produto(null, 1271, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod8 = new Produto(null, 1241, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod9 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod10 = new Produto(null, 1301, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod11 = new Produto(null, 3141, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod12 = new Produto(null, 3126, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod13 = new Produto(null, 3116, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod14 = new Produto(null, 2341, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod15 = new Produto(null, 6202, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod16 = new Produto(null, 8101, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod17 = new Produto(null, 4201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod18 = new Produto(null, 6201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod19 = new Produto(null, 9101, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod20 = new Produto(null, 9191, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod21 = new Produto(null, 3192, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod22 = new Produto(null, 3100, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod23 = new Produto(null, 2102, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod24 = new Produto(null, 2103, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod25 = new Produto(null, 1205, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod26 = new Produto(null, 1207, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod27 = new Produto(null, 1261, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod28 = new Produto(null, 2101, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod29 = new Produto(null, 7181, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod30 = new Produto(null, 3182, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod31 = new Produto(null, 8196, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod32 = new Produto(null, 6101, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod33 = new Produto(null, 1102, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod34 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod35 = new Produto(null, 1281, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod36 = new Produto(null, 1261, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod37 = new Produto(null, 1131, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod38 = new Produto(null, 3156, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod39 = new Produto(null, 3157, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod40 = new Produto(null, 3159, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod41 = new Produto(null, 2160, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod42 = new Produto(null, 2232, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod43 = new Produto(null, 1231, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod44 = new Produto(null, 1251, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod45 = new Produto(null, 1267, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod46 = new Produto(null, 1109, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod47 = new Produto(null, 3198, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod48 = new Produto(null, 3187, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod49 = new Produto(null, 3176, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod50 = new Produto(null, 2165, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod51 = new Produto(null, 2166, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod52 = new Produto(null, 1255, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod53 = new Produto(null, 1244, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod54 = new Produto(null, 1233, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod55 = new Produto(null, 1121, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod56 = new Produto(null, 3157, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod57 = new Produto(null, 3109, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod58 = new Produto(null, 3199, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod59 = new Produto(null, 2100, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod60 = new Produto(null, 2111, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod61 = new Produto(null, 1222, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod62 = new Produto(null, 1233, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod63 = new Produto(null, 1235, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod64 = new Produto(null, 1137, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod65 = new Produto(null, 3136, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod66 = new Produto(null, 3138, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod67 = new Produto(null, 3139, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod68 = new Produto(null, 2140, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod69 = new Produto(null, 2141, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod70 = new Produto(null, 1242, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod71 = new Produto(null, 1243, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod72 = new Produto(null, 1244, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod73 = new Produto(null, 1145, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod74 = new Produto(null, 3146, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod75 = new Produto(null, 3147, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod76 = new Produto(null, 3148, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod77 = new Produto(null, 2149, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod78 = new Produto(null, 2150, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod79 = new Produto(null, 1251, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod80 = new Produto(null, 1252, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod81 = new Produto(null, 1254, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod82 = new Produto(null, 1156, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod83 = new Produto(null, 3158, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod84 = new Produto(null, 3159, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod85 = new Produto(null, 3160, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod86 = new Produto(null, 2104, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod87 = new Produto(null, 2123, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod88 = new Produto(null, 1275, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod89 = new Produto(null, 1235, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod90 = new Produto(null, 1276, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod91 = new Produto(null, 1161, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod92 = new Produto(null, 3101, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod93 = new Produto(null, 3102, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod94 = new Produto(null, 3106, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod95 = new Produto(null, 2101, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod96 = new Produto(null, 2102, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod97 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod98 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod99 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod100 = new Produto(null, 1101, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod101 = new Produto(null, 1101, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod102 = new Produto(null, 3101, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod103 = new Produto(null, 3102, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod104 = new Produto(null, 3106, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod105 = new Produto(null, 2101, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod106 = new Produto(null, 2102, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod107 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod108 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod109 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod110 = new Produto(null, 1101, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod111 = new Produto(null, 3101, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod112 = new Produto(null, 3102, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod113 = new Produto(null, 3106, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod114 = new Produto(null, 2101, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod115 = new Produto(null, 2102, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod116 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod117 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod118 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod119 = new Produto(null, 1101, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod120 = new Produto(null, 3101, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod121 = new Produto(null, 3102, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod122 = new Produto(null, 3106, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod123 = new Produto(null, 2101, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod124 = new Produto(null, 2102, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod125 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod126 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod127 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod128 = new Produto(null, 1101, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod129 = new Produto(null, 3101, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod130 = new Produto(null, 3102, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod131 = new Produto(null, 3106, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod132 = new Produto(null, 2101, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod133 = new Produto(null, 2102, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod134 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod135 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod136 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod137 = new Produto(null, 1101, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod138 = new Produto(null, 3101, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod139 = new Produto(null, 3102, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod140 = new Produto(null, 3106, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod141 = new Produto(null, 2101, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod142 = new Produto(null, 2102, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod143 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod144 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod145 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod146 = new Produto(null, 1101, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod147 = new Produto(null, 3101, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod148 = new Produto(null, 3102, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod149 = new Produto(null, 3106, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod150 = new Produto(null, 2101, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod151 = new Produto(null, 2102, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod152 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod153 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod154 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod155 = new Produto(null, 1101, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod156 = new Produto(null, 3101, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod157 = new Produto(null, 3102, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod158 = new Produto(null, 3106, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod159 = new Produto(null, 2101, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod160 = new Produto(null, 2102, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod161 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod162 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod163 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod164 = new Produto(null, 1101, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod165 = new Produto(null, 3101, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod166 = new Produto(null, 3102, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod167 = new Produto(null, 3106, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod168 = new Produto(null, 2101, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod169 = new Produto(null, 2102, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod170 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod171 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod172 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod173 = new Produto(null, 1101, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod174 = new Produto(null, 3101, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod175 = new Produto(null, 3102, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod176 = new Produto(null, 3106, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod177 = new Produto(null, 2101, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod178 = new Produto(null, 2102, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod179 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod180 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod181 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod182 = new Produto(null, 1101, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod183 = new Produto(null, 3101, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod184 = new Produto(null, 3102, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod185 = new Produto(null, 3106, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod186 = new Produto(null, 2101, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod187 = new Produto(null, 2102, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod188 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod189 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod190 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod191 = new Produto(null, 1101, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//        Produto prod192 = new Produto(null, 3101, "Calcinha", false, 40.00, 48.00, StatusProduto.ativo);
//        Produto prod193 = new Produto(null, 3102, "Pijama Infantil", false, 50.00, 57.00, StatusProduto.ativo);
//        Produto prod194 = new Produto(null, 3106, "Pijama Casaco", false, 50.00, 59.00, StatusProduto.ativo);
//        Produto prod195 = new Produto(null, 2101, "Moleton",false, 80.00, 92.00, StatusProduto.ativo);
//        Produto prod196 = new Produto(null, 2102, "Cueca", false, 70.00, 80.00, StatusProduto.ativo);
//        Produto prod197 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod198 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod199 = new Produto(null, 1201, "Lencol", false, 30.00, 38.00, StatusProduto.ativo);
//        Produto prod200 = new Produto(null, 1101, "Conjunto Lingerie", true, 20.00, 25.00, StatusProduto.ativo);
//
//
//        associando produto e classe produto
//        prod1.setClasseProduto(classeProduto1);
//        prod2.setClasseProduto(classeProduto2);
//        prod3.setClasseProduto(classeProduto3);
//        prod4.setClasseProduto(classeProduto4);
//        prod5.setClasseProduto(classeProduto5);
//        prod6.setClasseProduto(classeProduto6);
//        prod7.setClasseProduto(classeProduto7);
//        prod8.setClasseProduto(classeProduto8);
//        prod9.setClasseProduto(classeProduto9);
//        prod10.setClasseProduto(classeProduto1);
//        prod11.setClasseProduto(classeProduto1);
//        prod12.setClasseProduto(classeProduto2);
//        prod13.setClasseProduto(classeProduto3);
//        prod14.setClasseProduto(classeProduto4);
//        prod15.setClasseProduto(classeProduto5);
//        prod16.setClasseProduto(classeProduto6);
//        prod17.setClasseProduto(classeProduto7);
//        prod18.setClasseProduto(classeProduto8);
//        prod19.setClasseProduto(classeProduto9);
//        prod20.setClasseProduto(classeProduto1);
//        prod21.setClasseProduto(classeProduto1);
//        prod22.setClasseProduto(classeProduto2);
//        prod23.setClasseProduto(classeProduto3);
//        prod24.setClasseProduto(classeProduto4);
//        prod25.setClasseProduto(classeProduto5);
//        prod26.setClasseProduto(classeProduto6);
//        prod27.setClasseProduto(classeProduto7);
//        prod28.setClasseProduto(classeProduto8);
//        prod29.setClasseProduto(classeProduto9);
//        prod30.setClasseProduto(classeProduto1);
//        prod31.setClasseProduto(classeProduto1);
//        prod32.setClasseProduto(classeProduto2);
//        prod33.setClasseProduto(classeProduto3);
//        prod34.setClasseProduto(classeProduto4);
//        prod35.setClasseProduto(classeProduto5);
//        prod36.setClasseProduto(classeProduto6);
//        prod37.setClasseProduto(classeProduto7);
//        prod38.setClasseProduto(classeProduto8);
//        prod39.setClasseProduto(classeProduto9);
//        prod40.setClasseProduto(classeProduto1);
//        prod41.setClasseProduto(classeProduto1);
//        prod42.setClasseProduto(classeProduto2);
//        prod43.setClasseProduto(classeProduto3);
//        prod44.setClasseProduto(classeProduto4);
//        prod45.setClasseProduto(classeProduto5);
//        prod46.setClasseProduto(classeProduto6);
//        prod47.setClasseProduto(classeProduto7);
//        prod48.setClasseProduto(classeProduto8);
//        prod49.setClasseProduto(classeProduto9);
//        prod50.setClasseProduto(classeProduto1);
//        prod51.setClasseProduto(classeProduto1);
//        prod52.setClasseProduto(classeProduto2);
//        prod53.setClasseProduto(classeProduto3);
//        prod54.setClasseProduto(classeProduto4);
//        prod55.setClasseProduto(classeProduto5);
//        prod56.setClasseProduto(classeProduto6);
//        prod57.setClasseProduto(classeProduto7);
//        prod58.setClasseProduto(classeProduto8);
//        prod59.setClasseProduto(classeProduto9);
//        prod60.setClasseProduto(classeProduto1);
//        prod61.setClasseProduto(classeProduto1);
//        prod62.setClasseProduto(classeProduto2);
//        prod63.setClasseProduto(classeProduto3);
//        prod64.setClasseProduto(classeProduto4);
//        prod65.setClasseProduto(classeProduto5);
//        prod66.setClasseProduto(classeProduto6);
//        prod67.setClasseProduto(classeProduto7);
//        prod68.setClasseProduto(classeProduto8);
//        prod69.setClasseProduto(classeProduto9);
//        prod70.setClasseProduto(classeProduto1);
//        prod71.setClasseProduto(classeProduto1);
//        prod72.setClasseProduto(classeProduto2);
//        prod73.setClasseProduto(classeProduto3);
//        prod74.setClasseProduto(classeProduto4);
//        prod75.setClasseProduto(classeProduto5);
//        prod76.setClasseProduto(classeProduto6);
//        prod77.setClasseProduto(classeProduto7);
//        prod78.setClasseProduto(classeProduto8);
//        prod79.setClasseProduto(classeProduto9);
//        prod80.setClasseProduto(classeProduto1);
//        prod81.setClasseProduto(classeProduto1);
//        prod82.setClasseProduto(classeProduto2);
//        prod83.setClasseProduto(classeProduto3);
//        prod84.setClasseProduto(classeProduto4);
//        prod85.setClasseProduto(classeProduto5);
//        prod86.setClasseProduto(classeProduto6);
//        prod87.setClasseProduto(classeProduto7);
//        prod88.setClasseProduto(classeProduto8);
//        prod89.setClasseProduto(classeProduto9);
//        prod90.setClasseProduto(classeProduto1);
//        prod91.setClasseProduto(classeProduto1);
//        prod92.setClasseProduto(classeProduto2);
//        prod93.setClasseProduto(classeProduto3);
//        prod94.setClasseProduto(classeProduto4);
//        prod95.setClasseProduto(classeProduto5);
//        prod96.setClasseProduto(classeProduto6);
//        prod97.setClasseProduto(classeProduto7);
//        prod98.setClasseProduto(classeProduto8);
//        prod99.setClasseProduto(classeProduto9);
//        prod100.setClasseProduto(classeProduto1);


//        //associando produtos e colecoes
//        prod1.getColecoes().addAll(Arrays.asList(col1, col3));
//        prod2.getColecoes().addAll(Arrays.asList(col1, col2, col3));
//        prod3.getColecoes().addAll(Arrays.asList(col1, col2, col3));
//        prod4.getColecoes().addAll(Arrays.asList(col1, col2, col3));
//        prod5.getColecoes().addAll(Arrays.asList(col1, col3));
//        prod6.getColecoes().addAll(Arrays.asList(col1, col3));
//        prod7.getColecoes().addAll(Arrays.asList(col1, col3));
//
//        //associando produtos e tamanhos
//        prod1.getTamanhosAceitos().addAll(Arrays.asList(101, 102, 103));

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
        classeProdutoRepository.saveAll(Arrays.asList(classeProduto1, classeProduto2, classeProduto3, classeProduto4,
                classeProduto5, classeProduto6, classeProduto7, classeProduto8, classeProduto9));

//        //persistindo produtos
//        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6, prod7));

        //persistindo usuarios
        usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3, usuario4));
    }


}
