package com.example.PI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class EntregaController {

    @Autowired
    private EntregaService entregaService;
    @GetMapping("/entregas")
    public Collection<Entrega> getEntregas(){
        return entregaService.getEntregas();
    }
    @GetMapping("/entregas/{id}")
    public Entrega getEntrega(@PathVariable long id){
        return entregaService.getEntrega(id);
    }
    @PostMapping("/entregas")
    public Entrega postEntrega(@RequestBody Entrega entrega){
        return entregaService.postEntregas(entrega);
    }
    @PutMapping("/entregas/{id}")
    public Entrega putEntrega(@PathVariable long id, @RequestBody Entrega entrega){
        return entregaService.putEntrega(id, entrega);}
    @DeleteMapping("/entregas/{id}")
    public void deleteEntrega(@PathVariable long id ){
        entregaService.deleteEntrega(id);

    }




}
