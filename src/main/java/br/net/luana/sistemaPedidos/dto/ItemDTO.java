package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.*;
import br.net.luana.sistemaPedidos.domain.enums.StatusItem;
import br.net.luana.sistemaPedidos.domain.enums.Tamanho;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Component
public class ItemDTO extends MasterDTOImpl<Item, ItemDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private PedidoDTOSemListas pedidoDTO = new PedidoDTOSemListas();

    private Integer id;

    private Integer statusItem;
    private LocalDate dataStatus;

    private ProdutoDTO produto;

    private ReferenciaDTO referenciaPrincipal;
    private ReferenciaDTO referenciaSecundaria;
    private Integer tamanhoPrincipal;
    private Integer tamanhoSecundario;
    private CorDTO corPrincipal;
    private CorDTO corSecundaria;

    private String textoLivre;

    private Double valor;

    private Double acrescimo;

    private Double desconto;

    private List<PedidoDTOSemListas> pedidos = new ArrayList<>();

    private EstoqueDTOSemListas estoque;

    public ItemDTO() {
    }

    public ItemDTO(Item entity) {
        this.id = entity.getId();
        this.statusItem = (entity.getStatusItem() == null) ? null : entity.getStatusItem().getId();
        this.dataStatus = entity.getDataStatus();
        this.produto = produto.makeDTO(entity.getProduto());
        this.referenciaPrincipal = referenciaPrincipal.makeDTO(entity.getReferenciaPrincipal());
        this.referenciaSecundaria = referenciaSecundaria.makeDTO(entity.getReferenciaSecundaria());
        this.tamanhoPrincipal = (entity.getTamanhoPrincipal() == null) ? null : entity.getTamanhoPrincipal().getId();
        this.tamanhoSecundario = (entity.getTamanhoSecundario() == null) ? null : entity.getTamanhoSecundario().getId();
        this.corPrincipal = corPrincipal.makeDTO(entity.getCorPrincipal());
        this.corSecundaria = corSecundaria.makeDTO(entity.getCorSecundaria());
        this.textoLivre = entity.getTextoLivre();
        this.valor = entity.getValor();
        this.acrescimo = entity.getAcrescimo();
        this.desconto = entity.getDesconto();
        this.pedidos = pedidoDTO.makeListDTO(entity.getPedidos());
        this.estoque = estoque.makeDTO(entity.getEstoque());
    }

    @Override
    public ItemDTO makeDTO(Item entity) {
        return new ItemDTO(entity);
    }

    @Override
    public Item makeEntityFromDTO(ItemDTO dto) {
        Item item = new Item();
        item.setStatusItem(StatusItem.toEnum(dto.getStatusItem()));
        item.setDataStatus(dto.getDataStatus());
        item.setProduto(produto.makeEntityFromDTO(dto.getProduto()));
        item.setReferenciaPrincipal(referenciaPrincipal.makeEntityFromDTO(dto.getReferenciaPrincipal()));
        item.setReferenciaSecundaria(referenciaSecundaria.makeEntityFromDTO(dto.getReferenciaSecundaria()));
        item.setTamanhoPrincipal(Tamanho.toEnum(dto.getTamanhoPrincipal()));
        item.setTamanhoSecundario(Tamanho.toEnum(dto.getTamanhoSecundario()));
        item.setCorPrincipal(corPrincipal.makeEntityFromDTO(dto.getCorPrincipal()));
        item.setCorSecundaria(corSecundaria.makeEntityFromDTO(dto.getCorSecundaria()));
        item.setTextoLivre(dto.getTextoLivre());
        item.setValor(dto.getValor());
        item.setAcrescimo(dto.getAcrescimo());
        item.setDesconto(dto.getDesconto());
        for (PedidoDTOSemListas pedidoDTOSemListas : dto.getPedidos()) {
            item.getPedidos().add(pedidoDTOSemListas.makeEntityFromDTO(pedidoDTOSemListas));
        }
        item.setEstoque(estoque.makeEntityFromDTO(dto.getEstoque()));
        
        return item;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatusItem() {
        return statusItem;
    }

    public void setStatusItem(Integer statusItem) {
        this.statusItem = statusItem;
    }

    public LocalDate getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(LocalDate dataStatus) {
        this.dataStatus = dataStatus;
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    public ReferenciaDTO getReferenciaPrincipal() {
        return referenciaPrincipal;
    }

    public void setReferenciaPrincipal(ReferenciaDTO referenciaPrincipal) {
        this.referenciaPrincipal = referenciaPrincipal;
    }

    public ReferenciaDTO getReferenciaSecundaria() {
        return referenciaSecundaria;
    }

    public void setReferenciaSecundaria(ReferenciaDTO referenciaSecundaria) {
        this.referenciaSecundaria = referenciaSecundaria;
    }

    public Integer getTamanhoPrincipal() {
        return tamanhoPrincipal;
    }

    public void setTamanhoPrincipal(Integer tamanhoPrincipal) {
        this.tamanhoPrincipal = tamanhoPrincipal;
    }

    public Integer getTamanhoSecundario() {
        return tamanhoSecundario;
    }

    public void setTamanhoSecundario(Integer tamanhoSecundario) {
        this.tamanhoSecundario = tamanhoSecundario;
    }

    public CorDTO getCorPrincipal() {
        return corPrincipal;
    }

    public void setCorPrincipal(CorDTO corPrincipal) {
        this.corPrincipal = corPrincipal;
    }

    public CorDTO getCorSecundaria() {
        return corSecundaria;
    }

    public void setCorSecundaria(CorDTO corSecundaria) {
        this.corSecundaria = corSecundaria;
    }

    public String getTextoLivre() {
        return textoLivre;
    }

    public void setTextoLivre(String textoLivre) {
        this.textoLivre = textoLivre;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(Double acrescimo) {
        this.acrescimo = acrescimo;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public List<PedidoDTOSemListas> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoDTOSemListas> pedidos) {
        this.pedidos = pedidos;
    }

    public EstoqueDTOSemListas getEstoque() {
        return estoque;
    }

    public void setEstoque(EstoqueDTOSemListas estoque) {
        this.estoque = estoque;
    }
}
