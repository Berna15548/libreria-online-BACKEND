package com.biblioteca.service.impl;

import com.biblioteca.models.Libro;
import com.biblioteca.repo.LibroRepo;
import com.biblioteca.service.LibroService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepo libroRepo;

    public LibroServiceImpl(LibroRepo libroRepo) {
        this.libroRepo = libroRepo;
    }

    @Override
    public Iterable<Libro> getAll() {
        return libroRepo.findAll();
    }

    @Override
    public Libro getById(Integer id) {
        return libroRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Libro no encontrado"));
    }

    @Override
    public Libro create(Libro libro) {
        return libroRepo.save(libro);
    }

    @Override
    public Libro modify(Libro libro) {
        if (!libroRepo.existsById(libro.getId())) {
            throw new NoSuchElementException("Libro no encontrado");
        }
        return libroRepo.save(libro);
    }

    @Override
    public void delete(Integer id) {
        libroRepo.deleteById(id);
    }
}
