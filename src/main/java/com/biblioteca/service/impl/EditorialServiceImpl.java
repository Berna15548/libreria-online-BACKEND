package com.biblioteca.service.impl;

import com.biblioteca.models.Editorial;
import com.biblioteca.repo.EditorialRepo;
import com.biblioteca.service.EditorialService;
import org.springframework.stereotype.Service;

@Service
public class EditorialServiceImpl implements EditorialService {
    private final EditorialRepo editorialRepo;

    /*CONSTRUCTOR*/
    EditorialServiceImpl(EditorialRepo editorialRepo) {
        this.editorialRepo = editorialRepo;
    }

    @Override
    public Iterable<Editorial> getAll() {
        return editorialRepo.findAll();
    }

    @Override
    public Editorial getById(int id) {
        return editorialRepo.findById(id).get();
    }

    @Override
    public Editorial createEditorial(Editorial editorial) {
        String nombre = editorial.getNombre();

        if (nombre == null || nombre.trim().isBlank()) {
            throw new IllegalArgumentException("El nombre de la editorial es obligatorio");
        }

        String nombreNormalizado = nombre.trim();
        
        return editorialRepo.findByNombreIgnoreCase(nombreNormalizado)
                
                .orElseGet(() -> {
            editorial.setNombre(nombreNormalizado);
            return editorialRepo.save(editorial);
        });
    }
    
    @Override
    public void delete(int id) {
        editorialRepo.deleteById(id);
    }
    
    @Override
    public Editorial modify(Editorial editorial) {
        return editorialRepo.save(editorial);
    }















}

