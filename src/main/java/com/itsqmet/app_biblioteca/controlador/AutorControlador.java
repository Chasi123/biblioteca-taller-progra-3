package com.itsqmet.app_biblioteca.controlador;

import com.itsqmet.app_biblioteca.entidad.Autor;
import com.itsqmet.app_biblioteca.entidad.Libro;
import com.itsqmet.app_biblioteca.servicio.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class AutorControlador {
    @Autowired
    private AutorServicio autorServicio;

    //Leer
    @GetMapping("/autores")
    public String listarAutor(@RequestParam(name = "buscarAutor", required = false, defaultValue = "") String buscarAutor, Model model) {
        List<Autor> autores = autorServicio.buscarLibroPorTitulo(buscarAutor);
        model.addAttribute("buscarAutor", buscarAutor);
        model.addAttribute("autores", autores);
        return "pages/listaAutores";
    }

    //    ingresar nuevo autor
    @GetMapping("/formularioAutor")
    public String formularioLibro(Model model) {
        model.addAttribute("autor", new Autor());
        return "pages/autor";
    }
    //    Guardar autor
    @PostMapping("/guardarAutor")
    public  String crearAutor(Autor autor){
        autorServicio.guardarAutor(autor);
        return "redirect:/autores";
    }

    //    Editar autor
    @GetMapping("/editarAutor/{id}")
    public String actualizarAutor(@PathVariable Long id, Model model){
        Optional<Autor> autor = autorServicio.buscarAutorPorid(id);
        model.addAttribute("autor", autor.orElse(new Autor()));
        return "pages/autor";
    }

    //    Eliminar autor
    @GetMapping("/eliminarAutor/{id}")
    public String eliminarAutor(@PathVariable long id){
        autorServicio.eliminarAutor(id);
        return "redirect:/autores";
    }
}
