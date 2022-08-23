package com.springproject.demo.controller;

import com.springproject.demo.model.Pedido;
import com.springproject.demo.service.PedidoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;
    
    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> listaPedidos(){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.listaPedidos());
    }
    
    @GetMapping("pedido/{codpedido}")
    public ResponseEntity<Optional<Pedido>> getByIdPedido(@PathVariable Integer codpedido){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.getByIdPedido(codpedido));
    }

    @PostMapping("pedido")
    public ResponseEntity<Pedido> salvaPedido(@RequestBody Pedido pedido){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.salvaPedido(pedido));
    }

    @PutMapping("pedido")
    public ResponseEntity<Pedido> atualizaPedido(@RequestBody Pedido pedido){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.atualizaPedido(pedido));
    }
    
    @DeleteMapping("pedido/{codpedido}")
    public ResponseEntity<String> deleteByIdPedido(@PathVariable Integer codpedido){
        pedidoService.deleteByIdPedido(codpedido);
        return ResponseEntity.status(HttpStatus.OK).body("Pedido removido com sucesso");
    }
}
