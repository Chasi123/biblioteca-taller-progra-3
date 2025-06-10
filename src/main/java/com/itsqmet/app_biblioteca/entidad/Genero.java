package com.itsqmet.app_biblioteca.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Genero{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;


    @OneToMany(mappedBy = "genero", fetch = FetchType.LAZY)
    private List<Libro> libros;

}
