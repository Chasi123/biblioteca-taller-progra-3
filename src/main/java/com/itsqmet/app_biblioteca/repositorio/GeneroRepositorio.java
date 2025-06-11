package com.itsqmet.app_biblioteca.repositorio;

import com.itsqmet.app_biblioteca.entidad.Genero;
import com.itsqmet.app_biblioteca.entidad.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepositorio extends JpaRepository<Genero, Long> {
}
