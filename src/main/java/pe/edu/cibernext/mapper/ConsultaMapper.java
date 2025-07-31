package pe.edu.cibernext.mapper;

import pe.edu.cibernext.models.ConsultaEntity;
import pe.edu.cibernext.models.dto.ConsultaConRespuestaDto;

import java.util.List;
import java.util.stream.Collectors;

public class ConsultaMapper {

    public static ConsultaConRespuestaDto toDto(ConsultaEntity consulta, Long idProfesor) {
        ConsultaConRespuestaDto dto = new ConsultaConRespuestaDto();
        dto.setId(consulta.getId());
        dto.setTitulo(consulta.getTitulo());
        dto.setMensaje(consulta.getMensaje());
        dto.setFecha(consulta.getFecha().toString());
        dto.setUnidad(consulta.getUnidadAprendizaje().getNombre());

        if (consulta.getRegistroAlumno() != null) {
            dto.setNombreAlumno(consulta.getRegistroAlumno().getAlumno().getNombre());
        }


        // Extrae la primera respuesta del profesor, si existe
        if (consulta.getRespuestas() != null) {
            consulta.getRespuestas().stream()
                    .filter(r -> r.getAutor().getId().equals(idProfesor))
                    .findFirst()
                    .ifPresent(r -> dto.setRespuesta(r.getMensaje()));
        }

        return dto;
    }

    public static List<ConsultaConRespuestaDto> toDtoList(List<ConsultaEntity> consultas, Long idProfesor) {
        return consultas.stream()
                .map(c -> toDto(c, idProfesor))
                .collect(Collectors.toList());
    }
}