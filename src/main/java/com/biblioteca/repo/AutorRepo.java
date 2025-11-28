package com.biblioteca.repo;

import com.biblioteca.models.Autor;
import com.biblioteca.models.Editorial;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AutorRepo extends CrudRepository<Autor, Integer> {
    
    Optional<Autor> findByNombreIgnoreCase(String nombre);
}
