package com.biblioteca.service.impl;

import com.biblioteca.models.Extencion;
import com.biblioteca.repo.ExtencionRepo;
import com.biblioteca.service.ExtencionService;
import org.springframework.stereotype.Service;

@Service
public class ExtencionServiceImpl implements ExtencionService {

    private final ExtencionRepo extencionRepo;

    public ExtencionServiceImpl(ExtencionRepo extencionRepo) {
        this.extencionRepo = extencionRepo;
    }

    @Override
    public Iterable<Extencion> getAll() {
        return extencionRepo.findAll();
    }

    @Override
    public Extencion getById(int id) {
        return extencionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Extensión no encontrada"));
    }

    @Override
    public Extencion create(Extencion extencion) {
        return extencionRepo.save(extencion);
    }

    @Override
    public Extencion modify(Extencion extencion) {
        if (!extencionRepo.existsById(extencion.getId())) {
            throw new RuntimeException("Extensión no encontrada");
        }
        return extencionRepo.save(extencion);
    }

    @Override
    public void delete(int id) {
        if (!extencionRepo.existsById(id)) {
            throw new RuntimeException("Extensión no encontrada");
        }
        extencionRepo.deleteById(id);
    }
}