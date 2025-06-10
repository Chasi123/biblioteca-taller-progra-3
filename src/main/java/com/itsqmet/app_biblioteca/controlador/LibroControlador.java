package com.itsqmet.app_biblioteca.controlador;

import com.itsqmet.app_biblioteca.entidad.Autor;
import com.itsqmet.app_biblioteca.entidad.Libro;
import com.itsqmet.app_biblioteca.servicio.AutorServicio;
import com.itsqmet.app_biblioteca.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LibroControlador {
    @Autowired
    private LibroServicio libroServicio;

    @Autowired
    private AutorServicio autorServicio;

    //Leer
    @GetMapping("/libros")
    public String listarLibros(@RequestParam(name = "buscarLibro", required = false, defaultValue = "") String buscarLibro, Model model) {
        List<Libro> libros = libroServicio.buscarLibroPorTitulo(buscarLibro);
        model.addAttribute("buscarLibro", buscarLibro);
        model.addAttribute("libros", libros);
        return "pages/listaLibros";
    }

    //    ingresar nuevo libto
    @GetMapping("/formularioLibro")
    public String formularioLibro(Model model) {
        model.addAttribute("libro", new Libro());
//        pasar autores desde el servicio autor al formulario
        List<Autor> autores = autorServicio.mostrarAutores();
        model.addAttribute("autores", autores);
        return "pages/libro";
    }
//    Guardar libro
    @PostMapping("/guardarLibro")
    public  String crearLibro(Libro libro){
        libroServicio.guardarLibro(libro);
        return "redirect:/libros";
    }

//    Editar libro
    @GetMapping("/editarLibro/{id}")
    public String actualizarLibro(@PathVariable Long id, Model model){
        Optional<Libro> libro = libroServicio.buscarLibroPorId(id);
        model.addAttribute("libro", libro.orElse(new Libro()));
//       Pasar los autpres desde el servicio autor al formukario
        List<Autor> autores = autorServicio.mostrarAutores();
        model.addAttribute("autores", autores);
        return "pages/libro";
    }

//    Eliminar libro
    @GetMapping("/eliminarLibro/{id}")
    public String eliminarLibro(@PathVariable long id){
        libroServicio.eliminarLibro(id);
        return "redirect:/libros";
    }
}