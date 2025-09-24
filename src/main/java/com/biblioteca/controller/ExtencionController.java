package com.biblioteca.controller;

import com.biblioteca.models.Extencion;
import com.biblioteca.service.ExtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/extencion")
@CrossOrigin
public class ExtencionController {

    private final ExtencionService service;

    @Autowired
    public ExtencionController(ExtencionService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Extencion> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Extencion> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Extencion> create(@RequestBody Extencion extencion) {
        return ResponseEntity.ok(service.create(extencion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Extencion> modify(@PathVariable int id, @RequestBody Extencion extencion) {
        extencion.setId(id);
        return ResponseEntity.ok(service.modify(extencion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}