package com.example.PI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class EntregadorController {
    @Autowired
    private EntregadorService entregadorService;

    @GetMapping("/entregadores")
    public Collection<Entregador> getEntregadores(){
        return entregadorService.getEntregadores();
    }

    @GetMapping("/entregadores/{documento}")
    public Entregador getEntregador(@PathVariable Integer documento) {
        return entregadorService.getEntregador(documento);
    }
    @PostMapping("/entregadores")
    public Entregador postEntregadores(@RequestBody Entregador entregador){
        return  entregadorService.postEntregadores(entregador);
    }
    @DeleteMapping("/entregadores/{cpf}")
    public void deleteEntregador(@PathVariable Integer documento){
        entregadorService.deleteEntregador(documento);
    }
    @PutMapping("/entregadores/{documento}")
    public Entregador putEntregador(@PathVariable Integer documento, @RequestBody Entregador entregador){
        return entregadorService.putEntregador(documento, entregador);
    }


}
