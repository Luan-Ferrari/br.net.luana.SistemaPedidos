package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.*;
import br.net.luana.sistemaPedidos.domain.enums.StatusProduto;
import br.net.luana.sistemaPedidos.domain.enums.Tamanho;
import br.net.luana.sistemaPedidos.dto.enums.StatusProdutoDTO;
import br.net.luana.sistemaPedidos.dto.enums.TamanhoDTO;

import br.net.luana.sistemaPedidos.service.validations.ProdutoInsert;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ProdutoInsert
public class ProdutoDTO extends MasterDTOImpl<Produto, ProdutoDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private ColecaoDTO colecaoDTO = new ColecaoDTO();

    private Integer id;
    private Integer codigoProduto;
    private String descricao;

    private Boolean conjunto;
    private Double valorAtacado;
    private Double valorVarejo;

    private StatusProdutoDTO statusProduto;

    private ClasseProdutoDTO classeProduto = new ClasseProdutoDTO();

    private List<ColecaoDTO> colecoes = new ArrayList<>();

    private List<TamanhoDTO> tamanhosAceitos = new ArrayList<>();

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto entity) {
        this.id = entity.getId();
        this.codigoProduto = entity.getCodigoProduto();
        this.descricao = entity.getDescricao();
        this.conjunto = entity.getConjunto();
        this.valorAtacado = entity.getValorAtacado();
        this.valorVarejo = entity.getValorVarejo();
        this.statusProduto = new StatusProdutoDTO(entity.getStatusProduto());
        this.classeProduto = classeProduto.makeDTO(entity.getClasseProduto());
        this.colecoes = colecaoDTO.makeListDTO(entity.getColecoes());
        for(Integer idTamanho : entity.getTamanhosAceitos()) {
            this.tamanhosAceitos.add(new TamanhoDTO(Tamanho.toEnum(idTamanho)));
        }
    }

    @Override
    public ProdutoDTO makeDTO(Produto entity) {
        return new ProdutoDTO(entity);
    }

    @Override
    public Produto makeEntityFromDTO(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setId(dto.getId());
        produto.setCodigoProduto(dto.getCodigoProduto());
        produto.setDescricao(dto.getDescricao());
        produto.setConjunto(dto.getConjunto());
        produto.setValorAtacado(dto.getValorAtacado());
        produto.setValorVarejo(dto.getValorVarejo());
        produto.setStatusProduto(StatusProduto.toEnum(dto.getStatusProduto().getId()));
        produto.setClasseProduto(classeProduto.makeEntityFromDTO(dto.getClasseProduto()));
        for (ColecaoDTO colecaoDTO : dto.getColecoes()) {
            produto.getColecoes().add(colecaoDTO.makeEntityFromDTO(colecaoDTO));
        }
        for (TamanhoDTO tamanhoAceitoDTO : dto.getTamanhosAceitos()) {
            produto.getTamanhosAceitos().add(tamanhoAceitoDTO.getId());
        }

        return produto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getConjunto() {
        return conjunto;
    }

    public void setConjunto(Boolean conjunto) {
        this.conjunto = conjunto;
    }

    public Double getValorAtacado() {
        return valorAtacado;
    }

    public void setValorAtacado(Double valorAtacado) {
        this.valorAtacado = valorAtacado;
    }

    public Double getValorVarejo() {
        return valorVarejo;
    }

    public void setValorVarejo(Double valorVarejo) {
        this.valorVarejo = valorVarejo;
    }

    public StatusProdutoDTO getStatusProduto() {
        return statusProduto;
    }

    public void setStatusProduto(StatusProdutoDTO statusProduto) {
        this.statusProduto = statusProduto;
    }

    public ClasseProdutoDTO getClasseProduto() {
        return classeProduto;
    }

    public void setClasseProduto(ClasseProdutoDTO classeProduto) {
        this.classeProduto = classeProduto;
    }

    public List<ColecaoDTO> getColecoes() {
        return colecoes;
    }

    public void setColecoes(List<ColecaoDTO> colecoes) {
        this.colecoes = colecoes;
    }

    public List<TamanhoDTO> getTamanhosAceitos() {
        return tamanhosAceitos;
    }

    public void setTamanhosAceitos(List<TamanhoDTO> tamanhosAceitos) {
        this.tamanhosAceitos = tamanhosAceitos;
    }
}
