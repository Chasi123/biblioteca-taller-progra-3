package com.itsqmet.app_biblioteca.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fechaPretsamo;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fechaDevolucion;


    @ManyToOne
    @JoinColumn(name = "codigo_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "codigo_libro")
    private Libro libro;


}
