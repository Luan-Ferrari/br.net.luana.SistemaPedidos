package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Colecao;
import br.net.luana.sistemaPedidos.domain.ColecaoCor;
import br.net.luana.sistemaPedidos.domain.Cor;
import br.net.luana.sistemaPedidos.repositories.ColecaoCorRepository;
import br.net.luana.sistemaPedidos.repositories.ColecaoRepository;
import br.net.luana.sistemaPedidos.service.exceptions.NumeracaoRepetidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ColecaoServiceImpl extends MasterServiceImpl<Colecao, Integer>
        implements ColecaoService {

    @Autowired
    ColecaoRepository colecaoRepository;
    @Autowired
    CorService corService;
    @Autowired
    ColecaoCorRepository colecaoCorRepository;

    public ColecaoServiceImpl(ColecaoRepository colecaoRepository) { super(colecaoRepository);}

    @Override
    public List<Integer> verificaNumeracaoDuplicadaInsert (List<Integer> numeracoes) {
        Set<Integer> numeracoesUnicas = new HashSet<>(numeracoes);
        List<Integer> numerosRepetidos = new ArrayList<>();
        for(Integer numero : numeracoesUnicas) {
            if(Collections.frequency(numeracoes, numero) > 1) {
                numerosRepetidos.add(numero);
            }
        }

        return numerosRepetidos;
    }

    public List<Integer> verificaNumeracaoDuplicadaUpdate (List<Integer> numeracoes,
                                                           List<Integer> numeracoesNovas) {
        numeracoes.addAll(numeracoesNovas);
        return verificaNumeracaoDuplicadaInsert(numeracoes);
    }

    //o metodo adicionar também altera o numero da cor dentro da colecao
    @Override
    public void adicionarItensColecao(Integer colecaoId, List<Cor> coresNovas,
                                      List<Integer> numeracoesNovas) {
        Colecao colecao = findById(colecaoId);
        List<Integer> numerosDuplicados = verificaNumeracaoDuplicadaUpdate(
                colecao.getNumeros(), numeracoesNovas);
        if(numerosDuplicados.isEmpty()) {
            for (int i = 0; i < coresNovas.size(); i++) {
                ColecaoCor cc = new ColecaoCor();
                cc.setCor(corService.findById(coresNovas.get(i).getId()));
                cc.setColecao(colecao);
                cc.setNumero(numeracoesNovas.get(i));
                colecaoCorRepository.save(cc);
            }
        } else {
            throw new NumeracaoRepetidaException(numerosDuplicados);
        }


    }

    @Override
    public void excluirItensColecao(Integer colecaoId, List<Cor> coresExcluir) {
        Colecao colecao = findById(colecaoId);
        for(Cor cor : coresExcluir) {
            ColecaoCor cc = new ColecaoCor();
            cc.setCor(corService.findById(cor.getId()));
            cc.setColecao(colecao);
            for(ColecaoCor cc1 : colecao.getItensCores()) {
                if (cc1.getCor() == cc.getCor()) {
                    colecaoCorRepository.delete(cc);
                }
            }

        }
    }

    @Override
    public Colecao save(Colecao entity) {
        List<Integer> numerosDuplicados = verificaNumeracaoDuplicadaInsert(entity.getNumeros());
        if(numerosDuplicados.isEmpty()) {
            entity = colecaoRepository.save(entity);
            for (ColecaoCor cc : entity.getItensCores()) {
                cc.setCor(corService.findById(cc.getCor().getId()));
                cc.setColecao(entity);
                colecaoCorRepository.save(cc);
            }
            return entity;
        } else {
            throw new NumeracaoRepetidaException(numerosDuplicados);
        }
    }


    @Override
    protected void updateData(Colecao updateEntity, Colecao entity) {

    }
}
