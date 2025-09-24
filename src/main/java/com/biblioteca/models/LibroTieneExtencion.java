package com.biblioteca.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "extencion_tiene_libro")
@Data

public class LibroTieneExtencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "libro_id", referencedColumnName = "id")
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "extencion_id", referencedColumnName = "id")
    private Extencion extencion;
    
    
}
