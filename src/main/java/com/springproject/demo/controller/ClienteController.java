package com.springproject.demo.controller;

import com.springproject.demo.model.Cliente;
import com.springproject.demo.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api("Api Clientes")
public class ClienteController {
    
    /* Injeção de depência via anotação */
    /* No instante que uma instância da classe CampoController é criada, uma instância da clsse CampoServiceImpl é injetada */
    /* elimina a necessidade de getters e setters nas classes que serão injetadas */
    /* não é a interface que é instanciada, mas a sua implementação */
    /* a interface esconde a implementação e só pode ter uma classe que a implemente. Caso contrário, ocorrerá um erro */
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> listaClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.listaClientes());
    }
    
    /* @PathVariable vincula o parâmetro passado pelo método com a variável do path */
    @GetMapping("cliente/{codcliente}")
    @ApiOperation("Obter detalhes de um cliente")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Cliente encontrado"),
        @ApiResponse(code = 404, message = "Cliente não encontrado")
    })
    public ResponseEntity<Optional<Cliente>> getByIdCliente(@PathVariable Integer codcliente){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.getByIdCliente(codcliente));
    }

    @PostMapping("cliente")
    public ResponseEntity<Cliente> salvaCliente(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvaCliente(cliente));
    }

    @PutMapping("cliente")
    public ResponseEntity<Cliente> atualizaCliente(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.atualizaCliente(cliente));
    }
    
    /* @PathVariable vincula o parâmetro passado pelo método com a variável do path */
    @DeleteMapping("cliente/{codcliente}")
    public ResponseEntity<String> deleteByIdCliente(@PathVariable Integer codcliente){
        clienteService.deleteByIdCliente(codcliente);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente removido com sucesso");
    }    
}
