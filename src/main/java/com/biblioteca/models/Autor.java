package com.biblioteca.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="autor")
@Data 
public class Autor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
            
    Integer id;
    String nombre;
}
