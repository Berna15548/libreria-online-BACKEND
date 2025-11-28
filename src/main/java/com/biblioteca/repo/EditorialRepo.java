package com.biblioteca.repo;

import com.biblioteca.models.Editorial;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EditorialRepo extends CrudRepository<Editorial,Integer> {

    Optional<Editorial> findByNombreIgnoreCase(String nombre);
}
