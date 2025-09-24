package com.biblioteca.repo;

import com.biblioteca.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepo extends JpaRepository<Libro,Integer> {}