package pe.edu.cibernext.controllers;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.ConsultaConRespuestaDto;
import pe.edu.cibernext.models.dto.CursoDto;
import pe.edu.cibernext.models.dto.ProfesorDto;
import pe.edu.cibernext.services.ConsultaService;
import pe.edu.cibernext.services.ProfesorService;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
@RequiredArgsConstructor
public class ProfesorController {

    private final ProfesorService profesorService;
    private final ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ProfesorDto> registrarProfesor(@RequestBody ProfesorDto profesorrDto) {
        ProfesorDto profesorDto = profesorService.registrar(profesorrDto);
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

    @GetMapping("/{idProfesor}/respondidas")
    public ResponseEntity<List<ConsultaConRespuestaDto>> obtenerRespondidasProfesor(
            @PathVariable @Positive Long idProfesor) {
        return ResponseEntity.ok(consultaService.listarRespondidasProfesor(idProfesor));
    }

    @GetMapping("/{idProfesor}/no-respondidas")
    public ResponseEntity<List<ConsultaConRespuestaDto>> obtenerNoRespondidasProfesor(
            @PathVariable @Positive Long idProfesor) {
        return ResponseEntity.ok(consultaService.listarNoRespondidasProfesor(idProfesor));
    }

}
