package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.ClasseProduto;
import br.net.luana.sistemaPedidos.domain.Personalizacao;
import br.net.luana.sistemaPedidos.domain.Referencia;
import br.net.luana.sistemaPedidos.repositories.ClasseProdutoRepository;
import br.net.luana.sistemaPedidos.repositories.OpcaoRepository;
import br.net.luana.sistemaPedidos.resources.ClasseProdutoResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseProdutoServiceImpl extends MasterServiceImpl<ClasseProduto, Integer>
        implements ClasseProdutoService {

    @Autowired
    ClasseProdutoRepository classeProdutoRepository;
    @Autowired
    ReferenciaService referenciaService;
    @Autowired
    PersonalizacaoService personalizacaoService;

    public ClasseProdutoServiceImpl(ClasseProdutoRepository classeProdutoRepository) {super(classeProdutoRepository);}


    @Override
    public void adicionarPersonalizacao(Integer classeProdutoId, List<Personalizacao> personalizacoes) {
        ClasseProduto classeProduto = findById(classeProdutoId);
        for(Personalizacao personalizacao : personalizacoes) {
            if(!classeProduto.getPersonalizacoes().contains(personalizacao)) {
                classeProduto.getPersonalizacoes().add(personalizacao);
            }
        }
        classeProdutoRepository.save(classeProduto);
    }

    @Override
    public void excluirPersonalizacao(Integer classeProdutoId, Personalizacao personalizacao) {
        ClasseProduto classeProduto = findById(classeProdutoId);
        if(classeProduto.getPersonalizacoes().contains(personalizacao)) {
            classeProduto.getPersonalizacoes().remove(personalizacao);
        }
        classeProdutoRepository.save(classeProduto);
    }

    @Override
    protected boolean updateData(ClasseProduto updateEntity, ClasseProduto entity) {
        return false;
    }
}
