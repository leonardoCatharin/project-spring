package com.springproject.demo.model;

import java.io.Serializable;
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
public class PedidoItem implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codpedidoitem")
    private int codPedidoItem;
    
    @ManyToOne
    @JoinColumn(name = "codproduto")
    private Produto produto;
    
    @Column(name = "quantidade")
    private double quantidade;

    public PedidoItem() {
    }

    public PedidoItem(int codPedidoItem, Produto produto, double quantidade) {
        this.codPedidoItem = codPedidoItem;
//        this.pedido = pedido;
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

    @Override
    public String toString() {
        return "PedidoItem{" + "codPedidoItem=" + codPedidoItem + ", produto=" + produto + ", quantidade=" + quantidade + '}';
    }
}
