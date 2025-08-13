package pe.edu.cibernext.services;

import pe.edu.cibernext.models.dto.ConsultaConRespuestaDto;
import pe.edu.cibernext.models.dto.ConsultaJerarquicaDto;

import java.util.List;

public interface ConsultaService {
    List<ConsultaConRespuestaDto> listarRespondidasProfesor(Long idProfesor);
    List<ConsultaConRespuestaDto> listarNoRespondidasProfesor(Long idProfesor);

    List<ConsultaJerarquicaDto> listarConsultasAlumno(Long idAlumno);
    List<ConsultaJerarquicaDto> listarConsultasNoRespondidasAlumno(Long idAlumno);

    List<ConsultaJerarquicaDto> listarConsultasUnidadAprendizaje(Long idUnidad);
}
