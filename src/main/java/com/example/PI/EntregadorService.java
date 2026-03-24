package com.example.PI;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EntregadorService {
    private HashMap<Integer, Entregador> entregadores = new HashMap<>();

    public Collection<Entregador> getEntregadores(){
        return entregadores.values();
    }
    public Entregador getEntregador(Integer documento){
        return entregadores.get(documento);
    }
    public Entregador postEntregadores(Entregador entregador){
        if(entregador.getDocumento() != null && entregador.getVeiculo() != null &&
                entregador.getEmail() != null && entregador.getNome() != null){
            entregadores.put(entregador.getDocumento(),entregador);
            return entregador;
        }
        return null;

    }
    public void deleteEntregador(Integer documento){
        entregadores.remove(documento);
    }
    public Entregador putEntregador(Integer documento, Entregador entregador){
        Entregador entregadorUpdated = entregadores.get(documento);
        if(entregador.getNome() != null){
            entregadorUpdated.setNome(entregador.getNome());
        }

        if(entregador.getEmail() != null){
            entregadorUpdated.setEmail(entregador.getEmail());
        }

        if(entregador.getDocumento() != null){
            entregadorUpdated.setDocumento(entregador.getDocumento());
        }

        if(entregador.getVeiculo() != null){
            entregadorUpdated.setVeiculo(entregador.getVeiculo());
        }
        return entregadorUpdated;
    }
    public Entregador getEntregadorAleatorio() {
        List<Entregador> lista = new ArrayList<>(entregadores.values());
        if (lista.isEmpty()) return null;

        Random rand = new Random();
        return lista.get(rand.nextInt(lista.size()));
    }
}
