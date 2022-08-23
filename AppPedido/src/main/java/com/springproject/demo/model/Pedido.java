package com.springproject.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "pedido")
public class Pedido implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codpedido")
    private int codPedido;
    
    @ManyToOne
    @JoinColumn(name = "codcliente", referencedColumnName = "codcliente")
    private Cliente cliente;
    
    @Column(name = "total")
    private double total;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoItem> itensPedido;

    public Pedido() {
    }

    public Pedido(int codPedido, Cliente cliente, double total) {
        this.codPedido = codPedido;
        this.cliente = cliente;
        this.total = total;
    }

    public Pedido(int codPedido, Cliente cliente, double total, List<PedidoItem> itensPedido) {
        this.codPedido = codPedido;
        this.cliente = cliente;
        this.total = total;
        this.itensPedido = itensPedido;
    }
    
    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<PedidoItem> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<PedidoItem> itenspedido) {
        this.itensPedido = itenspedido;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codPedido=" + codPedido + ", cliente=" + cliente + ", total=" + total + ", itenspedido=" + itensPedido + '}';
    }
}
