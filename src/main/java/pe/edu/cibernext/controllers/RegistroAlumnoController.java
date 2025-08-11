package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.RegistroAlumnoRequestDto;
import pe.edu.cibernext.models.dto.RegistroAlumnoResponseDto;
import pe.edu.cibernext.services.RegistroAlumnoService;

import java.util.List;

@RestController
@RequestMapping("/api/registro-alumno")
@RequiredArgsConstructor
public class RegistroAlumnoController {

    private final RegistroAlumnoService registroService;

    @PostMapping
    public ResponseEntity<RegistroAlumnoResponseDto> registrar(@RequestBody RegistroAlumnoRequestDto request) {
        RegistroAlumnoResponseDto response = registroService.registrar(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<RegistroAlumnoResponseDto>> listar() {
        return ResponseEntity.ok(registroService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroAlumnoResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(registroService.obtenerPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        registroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
