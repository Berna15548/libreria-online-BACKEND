package com.biblioteca.repo;

import com.biblioteca.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepo extends JpaRepository<Libro, Integer> {

    @Query("SELECT DISTINCT l FROM Libro l JOIN l.generos g WHERE g.id = :generoId")
    List<Libro> findByGeneroId(@Param("generoId") Integer generoId);

    @Query("SELECT l FROM Libro l WHERE LOWER(l.titulo) LIKE :filtro OR LOWER(l.autor.nombre) LIKE :filtro")
    List<Libro> buscarPorTituloOAutor(@Param("filtro") String filtro);

}