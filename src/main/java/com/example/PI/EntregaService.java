package com.example.PI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;

@Service
public class EntregaService {
    private long id =0;

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private EntregadorService entregadorService;

    private HashMap<Long, Entrega> entregas = new HashMap<>();

    public Collection<Entrega> getEntregas(){
        return entregas.values();
    }
    public Entrega getEntrega(Long id){
        return entregas.get(id);
    }
    public Entrega postEntregas(Entrega entrega){

        Integer clienteCpf = entrega.getCliente().getCpf();
        if(clienteService.getCliente(clienteCpf) == null){
            throw  new RuntimeException("Nao possui cliente");
        }

        Entregador entregador = entregadorService.getEntregadorAleatorio();
        if(entregador == null){
            throw  new RuntimeException("Nao possui entregador");

        }
        entrega.setId(id++);
        entrega.setDataSolicitacao(LocalDateTime.now());

        entregas.put(entrega.getId(),entrega);
        return entrega;
    }

    public void deleteEntrega(Long id){
        entregas.remove(id);

    }
    public Entrega putEntrega(Long id,Entrega entrega){
        Entrega entregaUpdated = entregas.get(id);
        if(entrega.getCliente() != null){

            Integer clienteCpf = entrega.getCliente().getCpf();
            if(clienteService.getCliente(clienteCpf) == null){
                throw  new RuntimeException("Nao possui cliente");
            }
            entregaUpdated.setCliente(entrega.getCliente());
        }
        if(entrega.getDataSolicitacao() != null){
            entregaUpdated.setDataSolicitacao(entrega.getDataSolicitacao());
        }
        return entregaUpdated;

    }


}
