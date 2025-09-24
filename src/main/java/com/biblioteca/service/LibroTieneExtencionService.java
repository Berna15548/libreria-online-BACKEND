package com.biblioteca.service;

import com.biblioteca.models.Libro;
import com.biblioteca.models.LibroTieneExtencion;

public interface LibroTieneExtencionService {
    Iterable<LibroTieneExtencion> getAll();
    LibroTieneExtencion getById(Integer id);
    LibroTieneExtencion create(LibroTieneExtencion libroTieneExtencion);
    LibroTieneExtencion modify(LibroTieneExtencion libroTieneExtencion);
    void delete(Integer id);
}
