package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.ClasseProduto;
import br.net.luana.sistemaPedidos.domain.Opcao;
import br.net.luana.sistemaPedidos.domain.Personalizacao;
import br.net.luana.sistemaPedidos.repositories.PersonalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonalizacaoServiceImpl extends MasterServiceImpl<Personalizacao, Integer>
        implements PersonalizacaoService {

    @Autowired
    PersonalizacaoRepository personalizacaoRepository;
    @Autowired
    OpcaoService opcaoService;


    public PersonalizacaoServiceImpl(PersonalizacaoRepository personalizacaoRepository) {
        super(personalizacaoRepository);
    }


    @Override
    public Personalizacao save(Personalizacao entity) {
        entity = personalizacaoRepository.save(entity);
        for (Opcao opcao : entity.getOpcoes()) {
            if(opcao.getId() != null ) {
                opcao = opcaoService.findById(opcao.getId());
            }
            opcao.getPersonalizacoes().add(entity);
            opcaoService.save(opcao);
        }
        return entity;
    }

    @Override
    public void adicionarOpcao(Integer personalizacaoId, List<Opcao> opcoes) {
        Personalizacao personalizacao = findById(personalizacaoId);
        for(Opcao opcao : opcoes) {
            if(!personalizacao.getOpcoes().contains(opcao)) {
                personalizacao.getOpcoes().add(opcao);
            }
        }
        personalizacaoRepository.save(personalizacao);
    }

    @Override
    public void excluirOpcao(Integer personalizacaoId, Opcao opcao) {
        Personalizacao personalizacao = findById(personalizacaoId);
        if(personalizacao.getOpcoes().contains(opcao)) {
            personalizacao.getOpcoes().remove(opcao);
        }
        personalizacaoRepository.save(personalizacao);
    }

    @Override
    protected void updateData(Personalizacao updateEntity, Personalizacao entity) {

    }
}
