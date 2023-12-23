package com.example.crudmvcestudiantes.Services;

import com.example.crudmvcestudiantes.Entity.Estudiante;

import java.util.List;

public interface EstudianteService {
    List<Estudiante> listarEstudiantes();
    Estudiante guardarEstudiante(Estudiante estudiante);
    Estudiante obtenerEstudiantePorId(Long id);
    Estudiante actualizarEstudiante(Estudiante estudiante);
    void eliminarEstudiante(Long id);
}
