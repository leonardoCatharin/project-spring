package com.springproject.demo.service;

import com.springproject.demo.model.Produto;
import com.springproject.demo.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Override
    public Produto salvaProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> getByIdProduto(Integer codProduto) {
        return produtoRepository.findById(codProduto);
    }

    @Override
    public Produto atualizaProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void deleteByIdProduto(Integer codProduto) {
        produtoRepository.deleteById(codProduto);
    }    
}
