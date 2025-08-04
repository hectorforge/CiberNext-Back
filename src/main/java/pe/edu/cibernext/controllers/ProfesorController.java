package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.ProfesorDto;
import pe.edu.cibernext.models.dto.ProfesorRegistroDto;
import pe.edu.cibernext.services.ProfesorService;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
@RequiredArgsConstructor
public class ProfesorController {

    private final ProfesorService profesorService;

    @PostMapping("/registrar")
    public ResponseEntity<ProfesorDto> registrarProfesor(@RequestBody ProfesorRegistroDto profesorRegistroDto) {
        ProfesorDto profesorDto = profesorService.registrar(profesorRegistroDto);
        return ResponseEntity.ok(profesorDto);
    }

    @GetMapping("/obtenerPorId/{id}")
    public ResponseEntity<ProfesorDto> obtenerProfesorPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(profesorService.buscarPorId(id));
    }

    @GetMapping("/verificarExistenciaPorId/{id}")
    public ResponseEntity<Boolean> verificarExistenciaPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(profesorService.verificarExistenciaPorId(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProfesorDto>> listarProfesores() {
        return ResponseEntity.ok(profesorService.listarTodos());
    }

    @DeleteMapping("/eliminarPorId/{id}")
    public ResponseEntity<Void> eliminarProfesor(@PathVariable("id") Long id) {
        profesorService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
