package com.itsqmet.app_biblioteca.servicio;

import com.itsqmet.app_biblioteca.entidad.Libro;
import com.itsqmet.app_biblioteca.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServicio {
    @Autowired
    private LibroRepositorio libroRepositorio;

    //    Mostrar libros
    public List<Libro> mostrarLibros() {
        return libroRepositorio.findAll();
    }

    //    Buscar libro por el titulo
    public List<Libro> buscarLibroPorTitulo(String buscarLibro) {
        if (buscarLibro == null || buscarLibro.isEmpty()) {
            return libroRepositorio.findAll();
        } else {
            return libroRepositorio.findByTituloContainingIgnoreCase(buscarLibro);
        }
    }

    //    buscar libro por id
    public Optional<Libro> buscarLibroPorId(Long id) {
        return libroRepositorio.findById(id);
    }

    //    Guardar libro
    public Libro guardarLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    //    Elimnar libro
    public void eliminarLibro(Long id) {
        libroRepositorio.deleteById(id);
    }

//    Buscar los libros por los autores
    public List<Libro> buscarLibrosPorAutor(Long id){
        List<Libro> librosAutor = libroRepositorio.findByAutorId(id);
        return librosAutor;
    }
}
