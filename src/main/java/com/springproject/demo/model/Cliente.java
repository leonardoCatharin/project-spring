package com.springproject.demo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "cliente")
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codcliente")
    private Integer codCliente;
    
    @Column(name = "nome")
    private String nome;

    public Cliente() {
    }

    public Cliente(int codcliente, String nome) {
        this.codCliente = codcliente;
        this.nome = nome;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codcliente) {
        this.codCliente = codcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codCliente=" + codCliente + ", nome=" + nome + '}';
    }
}
