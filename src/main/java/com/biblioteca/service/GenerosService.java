package com.biblioteca.service;

import com.biblioteca.models.Generos;

public interface GenerosService {

    Iterable<Generos> getAll();
    Generos getById(int id);
    Generos create(Generos generos);
    Generos modify(Generos generos);
    void delete(int id);

}
