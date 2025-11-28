package com.biblioteca.controller;

import com.biblioteca.models.Generos;
import com.biblioteca.service.GenerosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/generos")
@CrossOrigin
public class GenerosController {
    
    private final GenerosService service;

    @Autowired
    public GenerosController(GenerosService service) {
        this.service = service;
    }
    
    @GetMapping
    public Iterable<Generos> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Generos> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Generos> create(@RequestBody Generos generos) {
        return ResponseEntity.ok(service.create(generos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Generos> modify(@PathVariable int id, @RequestBody Generos generos) {
        generos.setId(id);
        return ResponseEntity.ok(service.modify(generos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }












    
}
