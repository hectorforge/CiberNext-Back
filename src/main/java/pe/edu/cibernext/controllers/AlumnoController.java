package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.AlumnoSimpleDto;
import pe.edu.cibernext.models.dto.CursoDto;
import pe.edu.cibernext.services.AlumnoService;
import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@RequiredArgsConstructor
public class AlumnoController {

    private final AlumnoService alumnoService;

    @GetMapping("/{id}/existe")
    public ResponseEntity<Boolean> verificarExistenciaPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(alumnoService.verificarExistenciaPorId(id));
    }

    @GetMapping()
    public ResponseEntity<List<AlumnoSimpleDto>> listarAlumnosPlano() {
        return ResponseEntity.ok(alumnoService.listarTodosPlano());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable("id") Long id) {
        alumnoService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoSimpleDto> obtenerAlumnoPlano(@PathVariable Long id) {
        return ResponseEntity.ok(alumnoService.buscarPlanoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoSimpleDto> actualizarAlumnoPlano(
            @PathVariable Long id,
            @RequestBody AlumnoSimpleDto dto) {
        return ResponseEntity.ok(alumnoService.actualizarPlano(id, dto));
    }

    @GetMapping("/{id}/cursos")
    public ResponseEntity<List<CursoDto>> listarCursosPorAlumno(@PathVariable("id") Long id) {
        return ResponseEntity.ok(alumnoService.listarCursosPorAlumno(id));
    }

}
