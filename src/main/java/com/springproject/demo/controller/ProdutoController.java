package com.springproject.demo.controller;

import com.springproject.demo.model.Produto;
import com.springproject.demo.service.ProdutoService;
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
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> listaProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listaProdutos());
    }
    
    @GetMapping("produto/{codproduto}")
    public ResponseEntity<Optional<Produto>> getByIdProduto(@PathVariable Integer codproduto){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getByIdProduto(codproduto));
    }

    @PostMapping("produto")
    public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvaProduto(produto));
    }

    @PutMapping("produto")
    public ResponseEntity<Produto> atualizaProduto(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.atualizaProduto(produto));
    }
    
    @DeleteMapping("produto/{codproduto}")
    public ResponseEntity<String> deleteByIdProduto(@PathVariable Integer codproduto){
        produtoService.deleteByIdProduto(codproduto);
        return ResponseEntity.status(HttpStatus.OK).body("Produto removido com sucesso");
    }
}
