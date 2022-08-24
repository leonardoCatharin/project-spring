package com.springproject.demo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "produto")
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codproduto")
    private Integer codProduto;
    
    @Column(name = "titulo")
    private String titulo;
    
    @Column(name = "preco")
    private double preco;

    public Produto() {
    }

    public Produto(int codProduto, String titulo, double preco) {
        this.codProduto = codProduto;
        this.titulo = titulo;
        this.preco = preco;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" + "codProduto=" + codProduto + ", titulo=" + titulo + ", preco=" + preco + '}';
    }
}
