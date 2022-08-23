package com.springproject.demo.repository;

import com.springproject.demo.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    
}
