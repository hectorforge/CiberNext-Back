package pe.edu.cibernext.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.UnidadAprendizajeDto;
import pe.edu.cibernext.models.dto.UnidadAprendizajeJerarquicoDto;
import pe.edu.cibernext.models.dto.UnidadAprendizajeRespuestaDto;
import pe.edu.cibernext.services.UnidadAprendizajeService;

import java.util.List;

@RestController
@RequestMapping("/api/unidades")
@RequiredArgsConstructor
public class UnidadAprendizajeController {

    private final UnidadAprendizajeService unidadService;

    @GetMapping("/obtenerPorId/{id}")
    public ResponseEntity<UnidadAprendizajeRespuestaDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(unidadService.buscarPorId(id));
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<UnidadAprendizajeRespuestaDto>> listarTodos() {
        return ResponseEntity.ok(unidadService.listarTodos());
    }

    @GetMapping("/listarPorCurso/{cursoId}")
    public ResponseEntity<List<UnidadAprendizajeRespuestaDto>> listarPorCurso(@PathVariable Long cursoId) {
        return ResponseEntity.ok(unidadService.listarPorCurso(cursoId));
    }

    @PostMapping("/registrar")
    public ResponseEntity<UnidadAprendizajeDto> registrar(@RequestBody UnidadAprendizajeDto dto) {
        return ResponseEntity.ok(unidadService.registrar(dto));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<UnidadAprendizajeDto> actualizar(@RequestBody UnidadAprendizajeDto dto) {
        return ResponseEntity.ok(unidadService.actualizar(dto));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        unidadService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/jerarquico")
    public List<UnidadAprendizajeJerarquicoDto> listarJerarquico() {
        return unidadService.listarJerarquico();
    }

}
