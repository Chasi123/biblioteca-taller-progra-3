package com.itsqmet.app_biblioteca.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String direccion;

    @OneToMany (mappedBy = "usuario")
    private List<Prestamo> prestamos;

    @OneToOne(mappedBy = "usuario")
    private Suscripcion suscripcion;

//    @ManyToMany
//    @JoinTable(name = "prestamo",
//    joinColumns = @JoinColumn(name = "codigo_usuario"),
//    inverseJoinColumns = @JoinColumn(name = "codigo_libro"))
//    private List<Libro> libros;

}
