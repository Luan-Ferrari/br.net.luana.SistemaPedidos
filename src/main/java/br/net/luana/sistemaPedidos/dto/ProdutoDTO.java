package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Component
public class ProdutoDTO extends MasterDTOImpl<Produto, ProdutoDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private ColecaoDTO colecaoDTO = new ColecaoDTO();
    private TamanhosAceitosDTO tamanhosAceitosDTO = new TamanhosAceitosDTO();

    private Integer id;
    private Integer codigoProduto;
    private Boolean conjunto;
    private Double valorAtacado;
    private Double valorVarejo;

    private Integer statusProduto;

    private ClasseProdutoDTO classeProduto;

    private List<ColecaoDTO> colecoes = new ArrayList<>();

    private List<TamanhosAceitosDTO> tamanhosAceitos = new ArrayList<>();

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto entity) {
        this.id = entity.getId();
        this.codigoProduto = entity.getCodigoProduto();
        this.conjunto = entity.getConjunto();
        this.valorAtacado = entity.getValorAtacado();
        this.valorVarejo = entity.getValorVarejo();
        this.classeProduto = classeProduto.makeDTO(entity.getClasseProduto());
        this.colecoes = colecaoDTO.makeListDTO(entity.getColecoes());
        this.tamanhosAceitos = tamanhosAceitosDTO.makeListDTO(entity.getTamanhosAceitos());
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
        produto.setConjunto(dto.getConjunto());
        produto.setValorAtacado(dto.getValorAtacado());
        produto.setValorVarejo(dto.getValorVarejo());
        produto.setClasseProduto(classeProduto.makeEntityFromDTO(dto.getClasseProduto()));
        for (ColecaoDTO colecaoDTO : dto.getColecoes()) {
            produto.getColecoes().add(colecaoDTO.makeEntityFromDTO(colecaoDTO));
        }
        for (TamanhosAceitosDTO tamanhosAceitosDTO : dto.getTamanhosAceitos()) {
            produto.getTamanhosAceitos().add(tamanhosAceitosDTO.makeEntityFromDTO(tamanhosAceitosDTO));
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

    public Integer getStatusProduto() {
        return statusProduto;
    }

    public void setStatusProduto(Integer statusProduto) {
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

    public List<TamanhosAceitosDTO> getTamanhosAceitos() {
        return tamanhosAceitos;
    }

    public void setTamanhosAceitos(List<TamanhosAceitosDTO> tamanhosAceitos) {
        this.tamanhosAceitos = tamanhosAceitos;
    }
}
