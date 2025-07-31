package pe.edu.cibernext.services;

import pe.edu.cibernext.models.dto.ConsultaConRespuestaDto;

import java.util.List;

public interface ConsultaService {
    List<ConsultaConRespuestaDto> listarRespondidas(Long idProfesor);
    List<ConsultaConRespuestaDto> listarNoRespondidas(Long idProfesor);
}
