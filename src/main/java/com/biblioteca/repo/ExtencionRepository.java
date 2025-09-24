package com.biblioteca.repo;

import com.biblioteca.models.Extencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtencionRepository extends JpaRepository<Extencion, Integer> {
}