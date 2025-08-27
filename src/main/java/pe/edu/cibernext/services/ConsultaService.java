package pe.edu.cibernext.services;

import pe.edu.cibernext.models.dto.*;

import java.util.List;

public interface ConsultaService {
    List<ConsultaJerarquicaDto> listarConsultasProfesor(Long idProfesor);
    List<ConsultaJerarquicaDto> listarConsultasNoRespondidasProfesor(Long idProfesor);

    List<ConsultaJerarquicaDto> listarConsultasAlumno(Long idAlumno);
    List<ConsultaJerarquicaDto> listarConsultasNoRespondidasAlumno(Long idAlumno);

    List<ConsultaJerarquicaDto> listarConsultasUnidadAprendizaje(Long idUnidad);

    ConsultaResponseDto registrarConsulta(ConsultaRequestDto dto);
    ConsultaResponseDto registrarRespuesta(RespuestaProfesorDto dto);

    List<ConsultaConRespuestaDto> listarRespondidasProfesor(Long idProfesor);
    List<ConsultaConRespuestaDto> listarNoRespondidasProfesor(Long idProfesor);
}
