package com.example.PI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public Collection<Cliente> getClientes(){
        return clienteService.getClientes();
    }

    @GetMapping("/clientes/{cpf}")
    public Cliente getCliente(@PathVariable Integer cpf) {
        return clienteService.getCliente(cpf);
    }
    @PostMapping("/clientes")
    public Cliente postCliente(@RequestBody Cliente cliente){
        return  clienteService.postCliente(cliente);
    }
    @DeleteMapping("/clientes/{cpf}")
    public void deleteCliente(@PathVariable Integer cpf){
        clienteService.deleteCliente(cpf);
    }
    @PutMapping("/clientes/{cpf}")
    public Cliente putCliente(@PathVariable Integer cpf, @RequestBody Cliente cliente){
        return clienteService.putCliente(cpf, cliente);
    }



}
