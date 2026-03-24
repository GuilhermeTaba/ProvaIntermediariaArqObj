package com.example.PI;

import org.springframework.stereotype.Service;
import tools.jackson.databind.util.Converter;

import java.util.Collection;
import java.util.HashMap;

@Service
public class ClienteService {
    private HashMap<Integer, Cliente> clientes = new HashMap<>();


    public Cliente postCliente(Cliente cliente){
        if(cliente.getCpf() != null && cliente.getTelefone() != null &&
        cliente.getNome() != null && cliente.getEmail() != null){
            clientes.put(cliente.getCpf(),cliente);
            return cliente;
        }
        return null;

    }
    public Collection<Cliente> getClientes(){
        return clientes.values();

    }
    public Cliente getCliente(Integer cpf){
        return clientes.get(cpf);

    }
    public void deleteCliente(Integer cpf){
        clientes.remove(cpf);
    }
    public Cliente putCliente(Integer cpf, Cliente cliente){
        Cliente clienteUpdated = clientes.get(cpf);
        if(cliente.getEmail() != null){
            clienteUpdated.setEmail(cliente.getEmail());
        }

        if(cliente.getCpf() != null){
            clienteUpdated.setCpf(cliente.getCpf());
        }
        if(cliente.getNome() != null){
            clienteUpdated.setNome(cliente.getNome());
        }

        if(cliente.getTelefone() != null){
            clienteUpdated.setTelefone(cliente.getTelefone());
        }
        return clienteUpdated;


    }

}
