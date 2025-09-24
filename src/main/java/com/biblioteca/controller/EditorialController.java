package com.biblioteca.controller;

import com.biblioteca.models.Editorial;
import com.biblioteca.service.EditorialService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/editorial")
@CrossOrigin
public class EditorialController {
    
    private final EditorialService service;
    /*CONSTRUCTOR*/
    public EditorialController(EditorialService service) {
        this.service = service;
    }
    
    @GetMapping
    public Iterable<Editorial> getEditorial() {
        return service.getAll();
    }
    
    @PostMapping
    public Editorial createEditorial(@RequestBody Editorial editorial) {
        return service.createEditorial(editorial);
    }

    @PutMapping("/{id}")
    public Editorial modifyEditorial(@PathVariable Integer id, @RequestBody Editorial editorial) {
        editorial.setId(id);
        return service.modify(editorial);
    }

    @DeleteMapping("/{id}")
    public void deleteEditorial(@PathVariable int id) {
        service.delete(id);
    }



}
