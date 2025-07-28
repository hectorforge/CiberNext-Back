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


    @GetMapping("/obtenerPorId/{id}")
    public ResponseEntity<CursoDto> obtenerPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(cursoService.buscarPorId(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CursoDto>> listar() {
        return ResponseEntity.ok(cursoService.listarTodos());
    }

    @PostMapping("/registrar")
    public ResponseEntity<CursoDto> registrar(@RequestBody CursoDto dto) {
        return ResponseEntity.ok(cursoService.registrar(dto));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<CursoDto> actualizar(@RequestBody CursoDto dto) {
        return ResponseEntity.ok(cursoService.actualizar(dto));
    }

    @DeleteMapping("/eliminarPorId/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Long id) {
        cursoService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
