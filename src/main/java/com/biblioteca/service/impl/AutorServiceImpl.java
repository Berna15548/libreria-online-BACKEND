package com.biblioteca.service.impl;
import com.biblioteca.models.Autor;
import com.biblioteca.repo.AutorRepo;
import com.biblioteca.service.AutorService;
import org.springframework.stereotype.Service;


@Service

public class AutorServiceImpl implements AutorService {
    private final AutorRepo autorRepo;

    public AutorServiceImpl(AutorRepo autorRepo) {
        this.autorRepo = autorRepo;
    }

    @Override
    public Iterable<Autor> getAll(){
        return autorRepo.findAll();
    }

    @Override
    public Autor getById(Integer id) {
        return autorRepo.findById(id).get();
    }

    @Override
    public Autor create(Autor autor) {
        String nombre = autor.getNombre();

        if (nombre == null || nombre.trim().isBlank()) {
            throw new IllegalArgumentException("El nombre del autor es obligatorio");
        }

        String nombreNormalizado = nombre.trim();

        return autorRepo.findByNombreIgnoreCase(nombreNormalizado)

                .orElseGet(() -> {
                    autor.setNombre(nombreNormalizado);
                    return autorRepo.save(autor);
                });
    }
    
    @Override
    public Autor modify(Autor autor) {
        return autorRepo.save(autor);
    }
    
    @Override
    public void delete(Integer id) {
        autorRepo.deleteById(id);
    }


}
