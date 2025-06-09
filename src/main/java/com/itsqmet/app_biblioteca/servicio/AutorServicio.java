package com.itsqmet.app_biblioteca.servicio;

import com.itsqmet.app_biblioteca.entidad.Autor;
import com.itsqmet.app_biblioteca.repositorio.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServicio {
    @Autowired
    private AutorRepositorio autorRepositorio;
    //    Mostrar autores
    public List<Autor> mostrarAutores() {
        return autorRepositorio.findAll();
    }
    //    Buscar autor por el nombre
    public List<Autor> buscarLibroPorTitulo(String buscarAutor) {
        if (buscarAutor == null || buscarAutor.isEmpty()) {
            return autorRepositorio.findAll();
        } else {
            return autorRepositorio.findByNombreContainingIgnoreCase(buscarAutor);
        }
    }
    //    buscar autor por id
    public Optional<Autor> buscarAutorPorid(Long id) {
        return autorRepositorio.findById(id);
    }

    //    Guardar autor
    public Autor guardarAutor(Autor autor) {
        return autorRepositorio.save(autor);
    }

    //    Elimnar autor
    public void eliminarAutor(Long id) {
        autorRepositorio.deleteById(id);
    }
}
