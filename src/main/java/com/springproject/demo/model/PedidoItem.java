package com.springproject.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "pedidoitem")
public class PedidoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codpedidoitem")
    private Integer codPedidoItem;
    
    @ManyToOne
    @JoinColumn(name = "codpedido")
    @JsonIgnore
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(name = "codproduto")
    private Produto produto;
    
    @Column(name = "quantidade")
    private double quantidade;

    public PedidoItem() {
    }

    public PedidoItem(int codPedidoItem, Pedido pedido, Produto produto, double quantidade) {
        this.codPedidoItem = codPedidoItem;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public PedidoItem(int codPedidoItem, Produto produto, double quantidade) {
        this.codPedidoItem = codPedidoItem;
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    public int getCodPedidoItem() {
        return codPedidoItem;
    }

    public void setCodPedidoItem(int codPedidoItem) {
        this.codPedidoItem = codPedidoItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    @Override
    public String toString() {
        return "PedidoItem{" + "codPedidoItem=" + codPedidoItem + ", produto=" + produto + ", quantidade=" + quantidade + '}';
    }
}
