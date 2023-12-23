package com.example.crudmvcestudiantes.Controllers;

import com.example.crudmvcestudiantes.Entity.Estudiante;
import com.example.crudmvcestudiantes.Services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;


    @GetMapping({"/estudiantes","/"})
    private String listarEstudiantes(Model model){
        model.addAttribute("estudiantes", estudianteService.listarEstudiantes());
        return "estudiantes"; //enviamos al html
    }
    @GetMapping("/estudiantes/nuevo")
    private String FormulariocrearEstudiante(Model model){
        Estudiante estudiante= new Estudiante();
        model.addAttribute("estudiante", estudiante);
        return "crear_estudiante"; //enviamos al html
    }
    @PostMapping("/estudiantes")
    public String guardarEstudianteCreado(@ModelAttribute("estudiante") Estudiante estudiante, Model model){
        estudianteService.guardarEstudiante(estudiante);
        return "redirect:estudiantes";
    }
    @GetMapping("/estudiantes/editar/{id}")
    public String FormularioEditarEstudiante(@PathVariable Long id, Model model){
        model.addAttribute("estudiante", estudianteService.obtenerEstudiantePorId(id));
        return "editar_estudiante";
    }
    @PostMapping("/estudiantes/{id}")
    public String ActualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante, Model model){
        Estudiante estudianteExistente= estudianteService.obtenerEstudiantePorId(id);
        estudianteExistente.setId(id);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEmail(estudiante.getEmail());
        estudianteService.actualizarEstudiante(estudianteExistente);
        return "redirect:/estudiantes";
    }
    @GetMapping("/estudiantes/{id}")
    public String eliminar(@PathVariable Long id){
        estudianteService.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
}
