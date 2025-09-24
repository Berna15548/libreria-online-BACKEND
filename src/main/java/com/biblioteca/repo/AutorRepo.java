package com.biblioteca.repo;

import com.biblioteca.models.Autor;
import org.springframework.data.repository.CrudRepository;

public interface AutorRepo extends CrudRepository<Autor, Integer> {
}
