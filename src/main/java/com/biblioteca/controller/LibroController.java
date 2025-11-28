package com.biblioteca.controller;
import com.biblioteca.models.*;
import com.biblioteca.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libro")
@CrossOrigin

public class LibroController {
  
    private final LibroService service;

    public LibroController(LibroService service){
        this.service = service;
    }
    
    @GetMapping()
    public Iterable<Libro> getLibro() {
        return service.getAll();
    }

    @GetMapping("/por-genero")
    public List<Libro> filtrarPorGenero(@RequestParam Integer generoId) {
        return service.filtrarPorGenero(generoId);
    }

    @GetMapping("/buscar")  
    public List<Libro> buscarLibros(@RequestParam String q) {
        return service.buscarLibros(q);
    }

    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public Libro create(@RequestBody Libro libro) {
        return service.create(libro);
    }

    @PutMapping("/{id}")
    public Libro modifyLibro(@PathVariable int id, @RequestBody Libro libro) {
        libro.setId(id);
        return service.modify(libro);
    }
    
    @DeleteMapping ("/{id}")
    public void deleteLibro(@PathVariable int id) {
        service.delete(id);
    }


    
}
