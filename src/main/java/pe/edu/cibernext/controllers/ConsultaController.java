package pe.edu.cibernext.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibernext.models.dto.ConsultaConRespuestaDto;
import pe.edu.cibernext.services.ConsultaService;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @GetMapping("/profesor/{idProfesor}/respondidas")
    public List<ConsultaConRespuestaDto> obtenerRespondidas(@PathVariable Long idProfesor) {
        return consultaService.listarRespondidas(idProfesor);
    }

    @GetMapping("/profesor/{idProfesor}/no-respondidas")
    public List<ConsultaConRespuestaDto> obtenerNoRespondidas(@PathVariable Long idProfesor) {
        return consultaService.listarNoRespondidas(idProfesor);
    }


    // TODO: Falta implementar
    /*
     - Consultas del alumno que están respondidas y no respondidas
     - ConsultasPorCurso

     Todas las consultas deben estar ordenadas jerárquicamente: curso -> unidad de aprendizaje -> pregunta.
     */
}
