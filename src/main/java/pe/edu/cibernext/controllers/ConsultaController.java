package pe.edu.cibernext.controllers;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibernext.models.dto.*;
import pe.edu.cibernext.services.ConsultaService;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
@RequiredArgsConstructor
@Validated
public class ConsultaController {

    private final ConsultaService consultaService;

    @GetMapping("/profesor/{idProfesor}/respondidas")
    public ResponseEntity<List<ConsultaConRespuestaDto>> obtenerRespondidasProfesor(
            @PathVariable @Positive Long idProfesor) {
        return ResponseEntity.ok(consultaService.listarRespondidasProfesor(idProfesor));
    }

    @GetMapping("/profesor/{idProfesor}/no-respondidas")
    public ResponseEntity<List<ConsultaConRespuestaDto>> obtenerNoRespondidasProfesor(
            @PathVariable @Positive Long idProfesor) {
        return ResponseEntity.ok(consultaService.listarNoRespondidasProfesor(idProfesor));
    }

    @GetMapping("/alumno/{idAlumno}/todas")
    public ResponseEntity<List<ConsultaJerarquicaDto>> obtenerTodasAlumno(
            @PathVariable @Positive Long idAlumno) {
        return ResponseEntity.ok(consultaService.listarConsultasAlumno(idAlumno));
    }

    // No respondidas por el profesor
    @GetMapping("/alumno/{idAlumno}/no-respondidas")
    public ResponseEntity<List<ConsultaJerarquicaDto>> obtenerNoRespondidasAlumno(
            @PathVariable @Positive Long idAlumno) {
        return ResponseEntity.ok(consultaService.listarConsultasNoRespondidasAlumno(idAlumno));
    }

    @GetMapping("/unidad/{idUnidad}/todas")
    public ResponseEntity<List<ConsultaJerarquicaDto>> obtenerConsultasUnidadAprendizaje(
            @PathVariable @Positive Long idUnidad) {
        return ResponseEntity.ok(consultaService.listarConsultasUnidadAprendizaje(idUnidad));
    }

    @PostMapping("/registrar")
    public ResponseEntity<ConsultaResponseDto> registrarConsulta(@RequestBody ConsultaRequestDto dto) {
        return ResponseEntity.ok(consultaService.registrarConsulta(dto));
    }

    @PostMapping("/responder")
    public ResponseEntity<ConsultaResponseDto> registrarRespuesta(@RequestBody RespuestaProfesorDto dto) {
        return ResponseEntity.ok(consultaService.registrarRespuesta(dto));
    }
}
