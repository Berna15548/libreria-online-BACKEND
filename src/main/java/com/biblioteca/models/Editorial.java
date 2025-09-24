package com.biblioteca.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "editorial")
@Data
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nombre;
    boolean esExtranjera;

    
}
