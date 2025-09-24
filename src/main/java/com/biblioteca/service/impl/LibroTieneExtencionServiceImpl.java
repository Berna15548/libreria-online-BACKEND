package com.biblioteca.service.impl;

import com.biblioteca.models.LibroTieneExtencion;
import com.biblioteca.repo.LibroTieneExtencionRepo;
import com.biblioteca.service.LibroTieneExtencionService;
import org.springframework.stereotype.Service;

@Service
public class LibroTieneExtencionServiceImpl implements LibroTieneExtencionService {
    private final LibroTieneExtencionRepo libroTieneExtencionRepo;

    /*CONSTRUCTOR*/
    LibroTieneExtencionServiceImpl(LibroTieneExtencionRepo libroTieneExtencionRepo) {
        this.libroTieneExtencionRepo = libroTieneExtencionRepo;
    }

    @Override
    public Iterable<LibroTieneExtencion> getAll() {
        return libroTieneExtencionRepo.findAll();
    }

    @Override
    public LibroTieneExtencion getById(Integer id) {
        return libroTieneExtencionRepo.findById(id).get();
    }

    @Override
    public LibroTieneExtencion create(LibroTieneExtencion libroTieneExtencion) {
        return libroTieneExtencionRepo.save(libroTieneExtencion);
    }
    @Override
    public void delete(Integer id) {
        libroTieneExtencionRepo.deleteById(id);
    }

    @Override
    public LibroTieneExtencion modify(LibroTieneExtencion libroTieneExtencion) {
        return libroTieneExtencionRepo.save(libroTieneExtencion);
    }















}

