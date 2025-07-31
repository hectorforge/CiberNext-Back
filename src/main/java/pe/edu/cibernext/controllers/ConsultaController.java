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

    @GetMapping("/respondidas/{idProfesor}")
    public List<ConsultaConRespuestaDto> obtenerRespondidas(@PathVariable Long idProfesor) {
        return consultaService.listarRespondidas(idProfesor);
    }

    @GetMapping("/no-respondidas/{idProfesor}")
    public List<ConsultaConRespuestaDto> obtenerNoRespondidas(@PathVariable Long idProfesor) {
        return consultaService.listarNoRespondidas(idProfesor);
    }
}
