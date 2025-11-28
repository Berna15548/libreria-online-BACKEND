package com.biblioteca.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="autor")
@Data /*esto le avisa a lombok para q genere getters, setters y mas*/
public class Autor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
            
    Integer id;
    String nombre;
}
