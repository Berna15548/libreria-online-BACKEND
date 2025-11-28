package com.biblioteca.repo;

import com.biblioteca.models.Generos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerosRepo extends JpaRepository <Generos, Integer>{
}
