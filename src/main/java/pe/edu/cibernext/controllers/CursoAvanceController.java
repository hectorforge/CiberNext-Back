package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.CursoAlumnoAvanceDto;
import pe.edu.cibernext.models.dto.UnidadVistaDto;
import pe.edu.cibernext.services.CursoAvanceService;

@RestController
@RequestMapping("/api/avance")
@RequiredArgsConstructor
public class CursoAvanceController {

    private final CursoAvanceService cursoAvanceService;

    @GetMapping("/curso/{cursoId}/alumno/{alumnoId}")
    public ResponseEntity<CursoAlumnoAvanceDto> obtenerAvance(
            @PathVariable Long cursoId,
            @PathVariable Long alumnoId
    ) {
        return ResponseEntity.ok(cursoAvanceService.calcularAvance(cursoId, alumnoId));
    }

    @PostMapping("/registrar-vista")
    public ResponseEntity<String> registrarUnidadVista(@RequestBody UnidadVistaDto request) {
        cursoAvanceService.registrarUnidadVista(request);
        return ResponseEntity.ok("Unidad visualizada correctamente");
    }
}
