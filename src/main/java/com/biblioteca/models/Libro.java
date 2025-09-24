package com.biblioteca.models;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "libro")
@Data
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            
    Integer id;
    String titulo;
    
    @ManyToOne
    @JoinColumn(name = "id_autor")
    Autor autor;
    
    @ManyToOne
    @JoinColumn( name = "id_editorial")
    Editorial editorial;





}
