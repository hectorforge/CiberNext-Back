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


    @GetMapping("/alumno/{idAlumno}/todas")
    public ResponseEntity<List<ConsultaJerarquicaDto>> obtenerTodasAlumno(
            @PathVariable @Positive Long idAlumno) {
        return ResponseEntity.ok(consultaService.listarConsultasAlumno(idAlumno));
    }

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
