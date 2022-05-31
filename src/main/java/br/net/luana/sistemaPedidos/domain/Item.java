package br.net.luana.sistemaPedidos.domain;

import br.net.luana.sistemaPedidos.domain.enums.StatusItem;
import br.net.luana.sistemaPedidos.domain.enums.Tamanho;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Item implements MasterDomain, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer statusItem;
    private LocalDate dataStatus;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private Referencia referenciaPrincipal;
    private Referencia referenciaSecundaria;
    private Integer tamanhoPrincipal;
    private Integer tamanhoSecundario;
    private Cor corPrincipal;
    private Cor corSecundaria;

    private String textoLivre;

    private Double valor;

    private Double acrescimo;

    private Double desconto;

    @ManyToMany(mappedBy = "itens")
    private List<Pedido> pedidos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "estoque_id")
    private Estoque estoque;

    @OneToMany(mappedBy = "item")
    private List<HistoricoStatusItem> historicos = new ArrayList<>();

    public Item() {
    }

    public Item(Integer id, StatusItem statusItem, LocalDate dataStatus, Produto produto,
                Referencia referenciaPrincipal, Referencia referenciaSecundaria, Tamanho tamanhoPrincipal,
                Tamanho tamanhoSecundario, Cor corPrincipal, Cor corSecundaria, String textoLivre,
                Double valor, Double acrescimo, Double desconto, Estoque estoque) {
        this.id = id;
        this.statusItem = (statusItem == null) ? null : statusItem.getCodigo();
        this.dataStatus = dataStatus;
        this.produto = produto;
        this.referenciaPrincipal = referenciaPrincipal;
        this.tamanhoPrincipal = (tamanhoPrincipal == null) ? null : tamanhoPrincipal.getCodigo();
        this.tamanhoSecundario = (tamanhoSecundario == null) ? null : tamanhoSecundario.getCodigo();
        this.corPrincipal = corPrincipal;
        this.textoLivre = textoLivre;
        this.valor = valor;
        this.acrescimo = acrescimo;
        this.desconto = desconto;
        this.estoque = estoque;

        if(!produto.getConjunto()) {
            this.referenciaSecundaria = null;
            this.corSecundaria = null;
        } else {
            this.referenciaSecundaria = referenciaSecundaria;
            this.corSecundaria = corSecundaria;
        }
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StatusItem getStatusItem() {
        return StatusItem.toEnum(statusItem);
    }

    public void setStatusItem(StatusItem statusItem) {
        this.statusItem = (statusItem == null) ? null : statusItem.getCodigo();
    }

    public LocalDate getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(LocalDate dataStatus) {
        this.dataStatus = dataStatus;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Referencia getReferenciaPrincipal() {
        return referenciaPrincipal;
    }

    public void setReferenciaPrincipal(Referencia referenciaPrincipal) {
        this.referenciaPrincipal = referenciaPrincipal;
    }

    public Referencia getReferenciaSecundaria() {
        return referenciaSecundaria;
    }

    public void setReferenciaSecundaria(Referencia referenciaSecundaria) {
        this.referenciaSecundaria = referenciaSecundaria;
    }

    public Tamanho getTamanhoPrincipal() {
        return Tamanho.toEnum(tamanhoPrincipal);
    }

    public void setTamanhoPrincipal(Tamanho tamanhoPrincipal) {
        this.tamanhoPrincipal = (tamanhoPrincipal == null) ? null : tamanhoPrincipal.getCodigo();
    }

    public Tamanho getTamanhoSecundario() {
        return Tamanho.toEnum(tamanhoSecundario);
    }

    public void setTamanhoSecundario(Tamanho tamanhoSecundario) {
        this.tamanhoSecundario = (tamanhoSecundario == null) ? null : tamanhoSecundario.getCodigo();
    }

    public Cor getCorPrincipal() {
        return corPrincipal;
    }

    public void setCorPrincipal(Cor corPrincipal) {
        this.corPrincipal = corPrincipal;
    }

    public Cor getCorSecundaria() {
        return corSecundaria;
    }

    public void setCorSecundaria(Cor corSecundaria) {
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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public List<HistoricoStatusItem> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<HistoricoStatusItem> historicos) {
        this.historicos = historicos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item that = (Item) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
