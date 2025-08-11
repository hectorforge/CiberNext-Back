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

    @GetMapping("/{id}")
    public ResponseEntity<UnidadAprendizajeRespuestaDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(unidadService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<UnidadAprendizajeRespuestaDto>> listarTodos() {
        return ResponseEntity.ok(unidadService.listarTodos());
    }

    // TODO:  Debe mostrar la estructura jerárquica de las unidades de aprendizaje contenidas dentro de esta unidad
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

    // TODO: Para que se utiliza este endopoint?
    @GetMapping("/jerarquico")
    public List<UnidadAprendizajeJerarquicoDto> listarJerarquico() {
        return unidadService.listarJerarquico();
    }

}


// TODO: Falta implementar
/*
 - [Copiar a CursoController]
   Listar unidades de aprendizaje por curso.
 - Listar consultas por unidad de aprendizaje
   (mostrar la unidad de aprendizaje a la que pertenece la consulta. también mostrar las consultas jerarquicamente: curso -> unidad -> consulta)
 - Listar documentos por unidad de aprendizaje
   (mostrar la unidad de aprendizaje a la que pertenece el documento. también mostrar los documentos jerarquicamente: curso -> unidad -> documento)

*/
