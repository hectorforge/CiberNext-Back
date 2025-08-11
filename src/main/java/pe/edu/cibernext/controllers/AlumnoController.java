package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.AlumnoDto;
import pe.edu.cibernext.services.AlumnoService;
import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@RequiredArgsConstructor
public class AlumnoController {

    private final AlumnoService alumnoService;

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDto> obtenerAlumnoPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(alumnoService.buscarPorId(id));
    }

    @GetMapping("/{id}/existe")
    public ResponseEntity<Boolean> verificarExistenciaPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(alumnoService.verificarExistenciaPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<AlumnoDto>> listarAlumnos() {
        return ResponseEntity.ok(alumnoService.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable("id") Long id) {
        alumnoService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

}

// TODO: Falta implementar
// - Actualizar alumno
// - Lista de cursos por alumno
