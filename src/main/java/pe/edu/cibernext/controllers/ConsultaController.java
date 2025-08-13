package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibernext.models.dto.ConsultaConRespuestaDto;
import pe.edu.cibernext.models.dto.ConsultaJerarquicaDto;
import pe.edu.cibernext.services.ConsultaService;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @GetMapping("/profesor/{idProfesor}/respondidas")
    public List<ConsultaConRespuestaDto> obtenerRespondidasProfesor(@PathVariable Long idProfesor) {
        return consultaService.listarRespondidasProfesor(idProfesor);
    }

    @GetMapping("/profesor/{idProfesor}/no-respondidas")
    public List<ConsultaConRespuestaDto> obtenerNoRespondidasProfesor(@PathVariable Long idProfesor) {
        return consultaService.listarNoRespondidasProfesor(idProfesor);
    }

    @GetMapping("/alumno/{idAlumno}/todas")
    public List<ConsultaJerarquicaDto> obtenerTodasAlumno(@PathVariable Long idAlumno) {
        return consultaService.listarConsultasAlumno(idAlumno);
    }

    //no respondidas por el profesor
    @GetMapping("/alumno/{idAlumno}/no-respondidas")
    public List<ConsultaJerarquicaDto> obtenerNoRespondidasAlumno(@PathVariable Long idAlumno) {
        return consultaService.listarConsultasNoRespondidasAlumno(idAlumno);
    }

    @GetMapping("/unidad/{idUnidad}/todas")
    public List<ConsultaJerarquicaDto> obtenerConsultasUnidadAprendizaje(@PathVariable Long idUnidad) {
        return consultaService.listarConsultasUnidadAprendizaje(idUnidad);
    }
}
