package com.biblioteca.service.impl;

import com.biblioteca.models.Extencion;
import com.biblioteca.repo.ExtencionRepository;
import com.biblioteca.service.ExtencionService;
import org.springframework.stereotype.Service;

@Service
public class ExtencionServiceImpl implements ExtencionService {

    private final ExtencionRepository extencionRepository;

    public ExtencionServiceImpl(ExtencionRepository extencionRepository) {
        this.extencionRepository = extencionRepository;
    }

    @Override
    public Iterable<Extencion> getAll() {
        return extencionRepository.findAll();
    }

    @Override
    public Extencion getById(int id) {
        return extencionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Extensión no encontrada"));
    }

    @Override
    public Extencion create(Extencion extencion) {
        return extencionRepository.save(extencion);
    }

    @Override
    public Extencion modify(Extencion extencion) {
        if (!extencionRepository.existsById(extencion.getId())) {
            throw new RuntimeException("Extensión no encontrada");
        }
        return extencionRepository.save(extencion);
    }

    @Override
    public void delete(int id) {
        if (!extencionRepository.existsById(id)) {
            throw new RuntimeException("Extensión no encontrada");
        }
        extencionRepository.deleteById(id);
    }
}