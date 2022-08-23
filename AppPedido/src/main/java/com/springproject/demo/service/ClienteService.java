package com.springproject.demo.service;

import com.springproject.demo.model.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
    
    public Cliente salvaCliente(Cliente cliente);
    
    public List<Cliente> listaClientes();
    
    /*Optional evita exceções como ponteiros nulos por exemplo */
    public Optional<Cliente> getByIdCliente(Integer codCliente);
    
    public Cliente atualizaCliente(Cliente cliente);
    
    public void deleteByIdCliente(Integer codCliente);    
}
