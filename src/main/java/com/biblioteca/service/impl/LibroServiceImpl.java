package com.biblioteca.service.impl;

import com.biblioteca.models.Autor;
import com.biblioteca.models.Editorial;
import com.biblioteca.models.Libro;
import com.biblioteca.repo.AutorRepo;
import com.biblioteca.repo.EditorialRepo;
import com.biblioteca.repo.LibroRepo;
import com.biblioteca.service.LibroService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LibroServiceImpl implements LibroService {

    private final AutorRepo autorRepo;
    private final EditorialRepo editorialRepo;
    private final LibroRepo libroRepo;

    public LibroServiceImpl(
            AutorRepo autorRepo,
            EditorialRepo editorialRepo,
            LibroRepo libroRepo
    ) {
        this.autorRepo = autorRepo;
        this.editorialRepo = editorialRepo;
        this.libroRepo = libroRepo;
    }

    @Override
    public Iterable<Libro> getAll() {
        return libroRepo.findAll();
    }

    @Override
    public Libro getById(Integer id) {
        return libroRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Libro no encontrado"));
    }

    // ================================================================
    // ======================= CREATE ==============================
    // ================================================================
    @Override
    public Libro create(Libro libro) {

        libro.setAutor(resolverAutor(libro.getAutor()));
        libro.setEditorial(resolverEditorial(libro.getEditorial()));

        return libroRepo.save(libro);
    }

    // ================================================================
    // ======================== MODIFY =============================
    // ================================================================
    @Override
    public Libro modify(Libro libro) {

        if (!libroRepo.existsById(libro.getId())) {
            throw new NoSuchElementException("Libro no encontrado");
        }

        libro.setAutor(resolverAutor(libro.getAutor()));
        libro.setEditorial(resolverEditorial(libro.getEditorial()));

        return libroRepo.save(libro);
    }

    // ================================================================
    // ======================= DELETE ==============================
    // ================================================================
    @Override
    @Transactional
    public void delete(Integer id) {
        libroRepo.deleteById(id);
    }

    // ================================================================
    // ===================== FILTRAR GENERO ========================
    // ================================================================
    @Override
    public List<Libro> filtrarPorGenero(Integer generoId) {
        if (generoId == null) return libroRepo.findAll();
        return libroRepo.findByGeneroId(generoId);
    }

    // ================================================================
    // ===================== BUSCADOR ==============================
    // ================================================================
    @Override
    public List<Libro> buscarLibros(String query) {
        if (query == null || query.isBlank()) {
            return libroRepo.findAll();
        }
        String filtro = "%" + query.toLowerCase() + "%";
        return libroRepo.buscarPorTituloOAutor(filtro);
    }

    // ================================================================
    // ============= RESOLVER AUTOR / EDITORIAL ====================
    // ================================================================

    private Autor resolverAutor(Autor autor) {
        if (autor == null) return null;

        if (autor.getId() != null) {
            // Si se proporciona ID, buscar por ID
            return autorRepo.findById(autor.getId())
                    .orElseThrow(() -> new NoSuchElementException("Autor no encontrado con ID: " + autor.getId()));
        } else if (autor.getNombre() != null && !autor.getNombre().trim().isEmpty()) {
            // Si se proporciona nombre (sin ID), buscar o crear por nombre
            String nombre = autor.getNombre().trim();
            return autorRepo.findByNombreIgnoreCase(nombre)
                    .orElseGet(() -> {
                        Autor nuevo = new Autor();
                        nuevo.setNombre(nombre);
                        return autorRepo.save(nuevo);
                    });
        } else {
            return null;
        }
    }

    private Editorial resolverEditorial(Editorial editorial) {
        if (editorial == null) return null;

        if (editorial.getId() != null) {
            // Si se proporciona ID, buscar por ID
            return editorialRepo.findById(editorial.getId())
                    .orElseThrow(() -> new NoSuchElementException("Editorial no encontrada con ID: " + editorial.getId()));
        } else if (editorial.getNombre() != null && !editorial.getNombre().trim().isEmpty()) {
            // Si se proporciona nombre (sin ID), buscar o crear por nombre
            String nombre = editorial.getNombre().trim();
            return editorialRepo.findByNombreIgnoreCase(nombre)
                    .orElseGet(() -> {
                        Editorial nuevo = new Editorial();
                        nuevo.setNombre(nombre);
                        return editorialRepo.save(nuevo);
                    });
        } else {
            return null;
        }
    }
}