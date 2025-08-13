package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.AlumnoCursoDto;
import pe.edu.cibernext.models.dto.CursoDto;
import pe.edu.cibernext.models.dto.ProfesorCursoDto;
import pe.edu.cibernext.models.dto.UnidadAprendizajePorCursoDto;
import pe.edu.cibernext.services.CursoService;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;


    @GetMapping("/{id}")
    public ResponseEntity<CursoDto> obtenerPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(cursoService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<CursoDto>> listar() {
        return ResponseEntity.ok(cursoService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<CursoDto> registrar(@RequestBody CursoDto dto) {
        return ResponseEntity.ok(cursoService.registrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDto> actualizar(@PathVariable("id") Long id,
                                               @RequestBody CursoDto dto) {
        dto.setId(id);
        return ResponseEntity.ok(cursoService.actualizar(dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Long id) {
        cursoService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/alumnos")
    public ResponseEntity<List<AlumnoCursoDto>> listarAlumnosPorCurso(@PathVariable("id") Long idCurso) {
        return ResponseEntity.ok(cursoService.listarAlumnosPorCurso(idCurso));
    }

    @GetMapping("/{id}/profesores")
    public ResponseEntity<List<ProfesorCursoDto>> listarProfesoresPorCurso(@PathVariable("id") Long idCurso) {
        return ResponseEntity.ok(cursoService.listarProfesoresPorCurso(idCurso));
    }

    @GetMapping("/{id}/unidades")
    public ResponseEntity<List<UnidadAprendizajePorCursoDto>> listarUnidadesPorCurso(@PathVariable("id") Long idCurso) {
        return ResponseEntity.ok(cursoService.listarUnidadesArbolPorCurso(idCurso));
    }


}
