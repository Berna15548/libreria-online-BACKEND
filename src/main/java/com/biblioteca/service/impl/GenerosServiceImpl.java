package com.biblioteca.service.impl;
import com.biblioteca.models.Generos;
import com.biblioteca.repo.GenerosRepo;
import com.biblioteca.service.GenerosService;
import org.springframework.stereotype.Service;

@Service
public class GenerosServiceImpl implements GenerosService {
    private final GenerosRepo generosRepo;

    public GenerosServiceImpl (GenerosRepo generosRepo) {
        this.generosRepo = generosRepo;
    }

    @Override
    public Iterable<Generos> getAll() {
        return generosRepo.findAll();
    }

    @Override
    public Generos getById(int id) {
        return generosRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("genero no encontrado"));
    }

    @Override
    public Generos create(Generos generos) {
        return generosRepo.save(generos);
    }

    @Override
    public Generos modify(Generos generos) {
        if (!generosRepo.existsById(generos.getId())) {
            throw new RuntimeException("genero no encontrado");
        }
        return generosRepo.save(generos);
    }

    @Override
    public void delete(int id) {
        if (!generosRepo.existsById(id)) {
            throw new RuntimeException("genero no encontrado");
        }
        generosRepo.deleteById(id);
    }
}
