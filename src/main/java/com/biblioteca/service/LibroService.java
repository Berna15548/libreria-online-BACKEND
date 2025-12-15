package com.biblioteca.service;

import com.biblioteca.models.Libro;

import java.util.List;

public interface LibroService {
    Iterable<Libro> getAll();
    Libro getById(Integer id);
    Libro create(Libro libro);
    Libro modify(Libro libro);
    void delete(Integer id);
    List<Libro> filtrarPorGenero(Integer generoId);

    List<Libro> buscarLibros(String query);

}
