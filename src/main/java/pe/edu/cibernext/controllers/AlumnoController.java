package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.AlumnoDto;
import pe.edu.cibernext.models.dto.CursoDocumentoDto;
import pe.edu.cibernext.models.dto.CursoDto;
import pe.edu.cibernext.services.AlumnoService;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@RequiredArgsConstructor
public class AlumnoController {

    private final AlumnoService alumnoService;

    @PostMapping
    public ResponseEntity<AlumnoDto> registrarAlumno(@RequestBody AlumnoDto dto) {
        AlumnoDto alumnoDto = alumnoService.registrar(dto);
        return ResponseEntity.ok(alumnoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDto> actualizarAlumno(@RequestBody AlumnoDto dto, @PathVariable("id") Long id) {
        return ResponseEntity.ok(alumnoService.actualizar(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDto> obtenerAlumnoPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(alumnoService.buscarPorId(id));
    }

    @GetMapping("/{id}/existe")
    public ResponseEntity<Boolean> verificarExistenciaPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(alumnoService.verificarExistenciaPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<AlumnoDto>> listarAlumnos() {
        return ResponseEntity.ok(alumnoService.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable("id") Long id) {
        alumnoService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/cursos")
    public ResponseEntity<List<CursoDto>> listarCursos(@PathVariable("id") Long id) {
        return ResponseEntity.ok(alumnoService.listarCursos(id));
    }


    @GetMapping("/{id}/cursos-documentos")
    public ResponseEntity<List<CursoDocumentoDto>> listarCursosConDocumentos(@PathVariable("id") Long id) {
        return ResponseEntity.ok(alumnoService.listarCursosConDocumentos(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<AlumnoDto>> buscarPorFiltro(@RequestParam("filtro") String filtro) {
        return ResponseEntity.ok(alumnoService.buscarPorFiltro(filtro));
    }


}
