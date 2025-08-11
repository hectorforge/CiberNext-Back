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

    // TODO: Mostrar como en listarJerarquico para que muestre el detalle de la unidad de aprendizaje con sus sub unidades
    @GetMapping("/{id}")
    public ResponseEntity<UnidadAprendizajeRespuestaDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(unidadService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<UnidadAprendizajeRespuestaDto>> listarTodos() {
        return ResponseEntity.ok(unidadService.listarTodos());
    }

    // TODO:  Debe mostrar la estructura jerárquica de las unidades de aprendizaje contenidas dentro de esta unidad
    // Parecida a la lógica de listarJerarquico
    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<UnidadAprendizajeRespuestaDto>> listarPorCurso(@PathVariable Long cursoId) {
        return ResponseEntity.ok(unidadService.listarPorCurso(cursoId));
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

    // TODO: Eliminar endpoint
    @GetMapping("/jerarquico")
    public List<UnidadAprendizajeJerarquicoDto> listarJerarquico() {
        return unidadService.listarJerarquico();
    }

}


// TODO: Falta implementar
/*
- Listar consultas por unidad de aprendizaje: consulta -> respuestas (consultas anidadas).
- Listar documentos por unidad de aprendizaje:
*/
