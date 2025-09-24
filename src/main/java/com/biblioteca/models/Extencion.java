package com.biblioteca.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "extencion")
@Data
public class Extencion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    boolean pdf;
    boolean audio;
    boolean video;
    
    
}
