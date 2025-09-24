package com.biblioteca.controller;

import com.biblioteca.models.Autor;
import com.biblioteca.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.io.Console;

@RestController
@RequestMapping("/api/autor")
@CrossOrigin
public class AutorController {
    private final AutorService service;

    public AutorController(AutorService service) {
        this.service = service;
    }

    @GetMapping()
    public Iterable<Autor> getAutores(){
        return service.getAll();
    }
    
    @PostMapping
    public Autor createAutor(@RequestBody Autor autor){
        return service.create(autor);
    }

    @PutMapping("/{id}")
    public Autor modifyAutor(@PathVariable Integer id, @RequestBody Autor autor) {
        autor.setId(id);
        return service.modify(autor);
    }
    
    @DeleteMapping("/{id}")
    public void deleteAutor(@PathVariable Integer id) {
        service.delete(id);
    }

    
    
}
