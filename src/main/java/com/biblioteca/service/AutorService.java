package com.biblioteca.service;

import com.biblioteca.models.Autor;


public interface AutorService {
    Iterable<Autor> getAll();
    Autor getById(Integer id);
    Autor create(Autor autor);
    Autor modify(Autor autor);
    void delete(Integer id);
}
