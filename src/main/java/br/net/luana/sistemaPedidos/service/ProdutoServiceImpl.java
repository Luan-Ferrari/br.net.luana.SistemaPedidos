package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.ClasseProduto;
import br.net.luana.sistemaPedidos.domain.Colecao;
import br.net.luana.sistemaPedidos.domain.Produto;
import br.net.luana.sistemaPedidos.repositories.OpcaoRepository;
import br.net.luana.sistemaPedidos.repositories.ProdutoRepository;
import br.net.luana.sistemaPedidos.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.*;

@Service
@Transactional
public class ProdutoServiceImpl extends MasterServiceImpl<Produto, Integer>
        implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {super(produtoRepository);}

    public Produto findProdutoAtivoPorCodigo(Integer codigo) {
        return produtoRepository.findByCodigoProdutoAndStatusProduto(codigo, 1);
    }

    @Override
    public List<Integer> atualizarLista(List<Produto> lista, String tipoAtualizacao) {

        List<Integer> atualizacoesComErros = new ArrayList<>();

        if(tipoAtualizacao.equalsIgnoreCase("selecao")) {
            for (Produto produto : lista) {
                boolean atualizado = updateData(produtoRepository.findById(produto.getId()).get(), produto);
                if(!atualizado) {
                    atualizacoesComErros.add(produto.getCodigoProduto());
                }
            }
        } else if (tipoAtualizacao.equalsIgnoreCase("relacao")) {
            for (Produto produto : lista) {
                try {
                    boolean atualizado = updateDataPorRelacao(findProdutoAtivoPorCodigo(produto.getCodigoProduto()), produto);
                    if (!atualizado) {
                        atualizacoesComErros.add(produto.getCodigoProduto());
                    }
                } catch (Exception e) {
                    atualizacoesComErros.add(produto.getCodigoProduto());
                }
            }
        }
        return atualizacoesComErros;
    }

    @Transactional
    protected boolean updateDataPorRelacao(Produto updateEntity, Produto entity) {
        try {
            if (entity.getValorAtacado() != null
                    && entity.getValorAtacado().toString() != ""
                    && !entity.getValorAtacado().equals(updateEntity.getValorAtacado())) {
                updateEntity.setValorAtacado(entity.getValorAtacado());
            }
            if (entity.getValorVarejo() != null
                    && entity.getValorVarejo().toString() != ""
                    && !entity.getValorVarejo().equals(updateEntity.getValorVarejo())) {
                updateEntity.setValorVarejo(entity.getValorVarejo());
            }
            return true;
        } catch ( Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    protected boolean updateData(Produto updateEntity, Produto entity) {
        try {
            if (entity.getCodigoProduto() != null
                    && entity.getCodigoProduto().toString() != ""
                    && !entity.getCodigoProduto().equals(updateEntity.getCodigoProduto())
            ) {
                updateEntity.setCodigoProduto(entity.getCodigoProduto());
            }
            if (entity.getDescricao() != null
                    && entity.getDescricao() != ""
                    && !entity.getDescricao().equals(updateEntity.getDescricao())) {
                updateEntity.setDescricao(entity.getDescricao());
            }
            if (entity.getConjunto() != null
                    && !entity.getConjunto().equals(updateEntity.getConjunto())) {
                updateEntity.setConjunto(entity.getConjunto());
            }
            if (entity.getValorAtacado() != null
                    && entity.getValorAtacado().toString() != ""
                    && !entity.getValorAtacado().equals(updateEntity.getValorAtacado())) {
                updateEntity.setValorAtacado(entity.getValorAtacado());
            }
            if (entity.getValorVarejo() != null
                    && entity.getValorVarejo().toString() != ""
                    && !entity.getValorVarejo().equals(updateEntity.getValorVarejo())) {
                updateEntity.setValorVarejo(entity.getValorVarejo());
            }
            if (entity.getStatusProduto() != null
                    && !entity.getStatusProduto().equals(updateEntity.getStatusProduto())) {
                updateEntity.setStatusProduto(entity.getStatusProduto());
            }
            if (entity.getAdulto() != null
                    && !entity.getAdulto().equals(updateEntity.getAdulto())) {
                updateEntity.setAdulto(entity.getAdulto());
            }
            if (entity.getClasseProduto().getId() != null
                    && !entity.getClasseProduto().equals(updateEntity.getClasseProduto())) {
                updateEntity.setClasseProduto(entity.getClasseProduto());
            }
            if (entity.getColecoes() != null) {
                updateEntity.setColecoes(entity.getColecoes());
            }
            if (entity.getTamanhosAceitos() != null) {
                updateEntity.setTamanhosAceitos(entity.getTamanhosAceitos());
            }
            return true;
        } catch ( Exception e) {
            return false;
        }

    }
}
