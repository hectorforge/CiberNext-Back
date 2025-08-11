package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.CurriculaDto;
import pe.edu.cibernext.models.dto.CurriculaRespuestaDto;
import pe.edu.cibernext.services.CurriculaService;

import java.util.List;

@RestController
@RequestMapping("/api/curriculas")
@RequiredArgsConstructor
public class CurriculaController {

    private final CurriculaService curriculaService;

    @GetMapping("/{id}")
    public ResponseEntity<CurriculaRespuestaDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(curriculaService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<CurriculaRespuestaDto>> listarTodos() {
        return ResponseEntity.ok(curriculaService.listarTodos());
    }

    // TODO: Cambiar funcionalidad a listar cursos por AreaEspecialidad
    //    @GetMapping("/area/{areaId}/curso")
    public ResponseEntity<List<CurriculaRespuestaDto>> listarPorCurso(@PathVariable Long cursoId) {
        return ResponseEntity.ok(curriculaService.listarPorCurso(cursoId));
    }

    @PostMapping
    public ResponseEntity<CurriculaDto> registrar(@RequestBody CurriculaDto dto) {
        return ResponseEntity.ok(curriculaService.registrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CurriculaDto> actualizar(@RequestBody CurriculaDto dto) {
        return ResponseEntity.ok(curriculaService.actualizar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        curriculaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
