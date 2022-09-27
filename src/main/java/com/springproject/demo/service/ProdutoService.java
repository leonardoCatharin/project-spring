package com.springproject.demo.service;

import com.springproject.demo.model.Produto;
import java.util.List;
import java.util.Optional;

public interface ProdutoService {
    public Produto salvaProduto(Produto produto);
    
    public List<Produto> listaProdutos();
    
    public Optional<Produto> getByIdProduto(Integer codProduto);
    
    public Produto atualizaProduto(Produto produto);
    
    public void deleteByIdProduto(Integer codProduto);    
}
