package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.CursoDto;
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

    // TODO: Corregir la funcionalidad de este endpoint
    // Debe recibir un id de curricula en la url
    // para mantener la nomenclatura de los endpoints
    // @PutMapping("/{id}")
    @PutMapping("/actualizar")
    public ResponseEntity<CursoDto> actualizar(@RequestBody CursoDto dto) {
        return ResponseEntity.ok(cursoService.actualizar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Long id) {
        cursoService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}


//  TODO: Falta implementar
//  - Lista de alumnos por curso
//  - Lista de docentes por curso
//  - Detalles del curso debe contener una lista unidades de aprendizaje por curso (incluye documentos y consultas)}
