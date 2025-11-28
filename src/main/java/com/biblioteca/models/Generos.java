package com.biblioteca.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "generos")
@Data
public class Generos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    boolean literatura;
    boolean historia;
    boolean geografia;
    boolean novela;
    boolean ciencia;
    boolean cuento;
    boolean idioma;
    boolean arte;
    boolean desarrolloPersonal;

}
