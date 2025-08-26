package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.*;
import pe.edu.cibernext.services.CursoService;
import pe.edu.cibernext.services.DocumentoService;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;
    private final DocumentoService documentoService;


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

    @GetMapping("/buscar")
    public ResponseEntity<List<CursoDto>> buscarPorFiltro(@RequestParam("filtro") String filtro) {
        return ResponseEntity.ok(cursoService.buscarPorFiltro(filtro));
    }

    @PutMapping("/{id}/actualizar-documento")
    public ResponseEntity<DocumentoDto> actualizarActualizar( @PathVariable("id") Long id, @RequestBody DocumentoDto dto) {
        dto.setId(id);
        return ResponseEntity.ok(documentoService.actualizar(dto));
    }

    @GetMapping("/{id}/documentos")
    public ResponseEntity<List<DocumentoDto>> listarDocumentosPorCurso(@PathVariable("id") Long cursoId) {
        return ResponseEntity.ok(documentoService.listarDocumentosPorCurso(cursoId));
    }

     @DeleteMapping("/{id}/eliminar-documento")
    public ResponseEntity<Void> eliminarDocumento(@PathVariable("id")  Long id) {
        documentoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("registrar-documento")
    public ResponseEntity<DocumentoDto> registrarDocumento(@RequestBody DocumentoDto dto) {
        return ResponseEntity.ok(documentoService.registrar(dto));
    }


    @PostMapping("/{cursoId}/asignar-profesor/{profesorId}")
    public ResponseEntity<Void> asignarProfesor(@PathVariable Long cursoId, @PathVariable Long profesorId) {
        cursoService.asignarProfesor(cursoId, profesorId);
        return ResponseEntity.ok().build();
    }


}
