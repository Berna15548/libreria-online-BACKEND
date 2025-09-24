package com.biblioteca.service;

import com.biblioteca.models.Extencion;

public interface ExtencionService {
    Iterable<Extencion> getAll();
    Extencion getById(int id);
    Extencion create(Extencion extencion);
    Extencion modify(Extencion extencion);
    void delete(int id);
}