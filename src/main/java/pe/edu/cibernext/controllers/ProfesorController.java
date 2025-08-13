package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.CurriculaDto;
import pe.edu.cibernext.models.dto.CursoDto;
import pe.edu.cibernext.models.dto.ProfesorDto;
import pe.edu.cibernext.models.dto.ProfesorRegistroDto;
import pe.edu.cibernext.services.ProfesorService;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
@RequiredArgsConstructor
public class ProfesorController {

    private final ProfesorService profesorService;

    @PostMapping
    public ResponseEntity<ProfesorDto> registrarProfesor(@RequestBody ProfesorRegistroDto profesorRegistroDto) {
        ProfesorDto profesorDto = profesorService.registrar(profesorRegistroDto);
        return ResponseEntity.ok(profesorDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesorDto> actualizarProfesor(@RequestBody ProfesorDto dto, @PathVariable("id") Long id) {
        return ResponseEntity.ok(profesorService.actualizar(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorDto> obtenerProfesorPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(profesorService.buscarPorId(id));
    }

    @GetMapping("/{id}/existe")
    public ResponseEntity<Boolean> verificarExistenciaPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(profesorService.verificarExistenciaPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ProfesorDto>> listarProfesores() {
        return ResponseEntity.ok(profesorService.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProfesor(@PathVariable("id") Long id) {
        profesorService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/cursos")
    public ResponseEntity<List<CursoDto>> listarCursos(@PathVariable("id") Long id) {
        return ResponseEntity.ok(profesorService.listarCursos(id));
    }

}
