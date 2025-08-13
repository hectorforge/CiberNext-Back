package pe.edu.cibernext.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.*;
import pe.edu.cibernext.services.UnidadAprendizajeService;

import java.util.List;

@RestController
@RequestMapping("/api/unidades")
@RequiredArgsConstructor
public class UnidadAprendizajeController {

    private final UnidadAprendizajeService unidadService;

    @GetMapping("/unidad/{unidadId}/documentos")
    public ResponseEntity<List<DocumentoPorUnidadAprendizajeDto>> listarDocumentosPorUnidad(@PathVariable Long unidadId) {
        return ResponseEntity.ok(unidadService.listarDocumentosPorUnidad(unidadId));
    }

    @GetMapping("/jerarquico/{id}")
    public ResponseEntity<UnidadAprendizajeJerarquicoDto> obtenerJerarquicoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(unidadService.buscarJerarquicoPorId(id));
    }
    @GetMapping
    public ResponseEntity<List<UnidadAprendizajeRespuestaDto>> listarTodos() {
        return ResponseEntity.ok(unidadService.listarTodos());
    }
    
    @PostMapping
    public ResponseEntity<UnidadAprendizajeDto> registrar(@RequestBody UnidadAprendizajeDto dto) {
        return ResponseEntity.ok(unidadService.registrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadAprendizajeDto> actualizar(@RequestBody UnidadAprendizajeDto dto) {
        return ResponseEntity.ok(unidadService.actualizar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        unidadService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/consultas")
    public ResponseEntity<List<ConsultaPorUnidadAprendizajeDto>> listarConsultasPorUnidad(
            @PathVariable("id") Long idUnidad) {
        return ResponseEntity.ok(unidadService.listarConsultasArbolPorUnidad(idUnidad));
    }

    @GetMapping("/{id}/documentos")
    public ResponseEntity<List<DocumentoPorUnidadAprendizajeDto>> listarDocumentos(
            @PathVariable("id") Long idUnidad) {
        return ResponseEntity.ok(unidadService.listarDocumentosPorUnidad(idUnidad));
    }

}
