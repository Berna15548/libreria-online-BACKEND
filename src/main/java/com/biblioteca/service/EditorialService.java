package com.biblioteca.service;

import com.biblioteca.models.Editorial;

public interface EditorialService {
    Iterable<Editorial> getAll();
    Editorial getById(int id);
    Editorial createEditorial(Editorial editorial);
    Editorial modify(Editorial editorial);
    void delete(int id);
}
