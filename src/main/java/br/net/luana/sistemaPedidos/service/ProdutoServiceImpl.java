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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ProdutoServiceImpl extends MasterServiceImpl<Produto, Integer>
        implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {super(produtoRepository);}


    @Override
    protected void updateData(Produto updateEntity, Produto entity) {
        try {
            if (entity.getCodigoProduto() != null && entity.getCodigoProduto().toString() != "") {
                updateEntity.setCodigoProduto(entity.getCodigoProduto());
            }
            if (entity.getConjunto() != null) {
                updateEntity.setConjunto(entity.getConjunto());
            }
            if (entity.getValorAtacado() != null && entity.getValorAtacado().toString() != "") {
                updateEntity.setValorAtacado(entity.getValorAtacado());
            }
            if (entity.getValorVarejo() != null && entity.getValorVarejo().toString() != "") {
                updateEntity.setValorVarejo(entity.getValorVarejo());
            }
            if (entity.getStatusProduto() != null) {
                updateEntity.setStatusProduto(entity.getStatusProduto());
            }
            if (entity.getAdulto() != null) {
                updateEntity.setAdulto(entity.getAdulto());
            }
            if (entity.getClasseProduto() != null) {
                updateEntity.setClasseProduto(entity.getClasseProduto());
            }
            if (entity.getColecoes() != null) {
                updateEntity.setColecoes(entity.getColecoes());
            }
            if (entity.getTamanhosAceitos() != null) {
                updateEntity.setTamanhosAceitos(entity.getTamanhosAceitos());
            }
        } catch ( RuntimeException e) {

        }

    }
}
