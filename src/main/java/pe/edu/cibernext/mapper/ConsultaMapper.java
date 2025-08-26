package pe.edu.cibernext.mapper;

import pe.edu.cibernext.models.ConsultaEntity;
import pe.edu.cibernext.models.dto.ConsultaConRespuestaDto;
import pe.edu.cibernext.models.dto.ConsultaJerarquicaDto;
import pe.edu.cibernext.models.dto.ConsultaResponseDto;

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
            dto.setCurso(consulta.getRegistroAlumno().getCurso().getNombre());
        }

        if (consulta.getRespuestas() != null) {
            consulta.getRespuestas().stream()
                    .filter(r -> r.getAutor().getId().equals(idProfesor))
                    .findFirst()
                    .ifPresent(r -> dto.setRespuesta(r.getMensaje()));
        }

        return dto;
    }

    public static ConsultaJerarquicaDto toJerarquicoDto(ConsultaEntity consulta) {
        ConsultaJerarquicaDto dto = new ConsultaJerarquicaDto();
        dto.setId(consulta.getId());
        dto.setTitulo(consulta.getTitulo());
        dto.setMensaje(consulta.getMensaje());
        dto.setFecha(consulta.getFecha().toString());
        dto.setNombreAutor(consulta.getAutor().getNombre());
        dto.setUnidad(consulta.getUnidadAprendizaje().getNombre());
        dto.setCurso(consulta.getRegistroAlumno().getCurso().getNombre());

        dto.setIdAutor(consulta.getAutor().getId());
        dto.setIdUnidad(consulta.getUnidadAprendizaje().getId());
        dto.setIdRegistroAlumno(consulta.getRegistroAlumno().getId());

        if (consulta.getRespuestas() != null && !consulta.getRespuestas().isEmpty()) {
            List<ConsultaJerarquicaDto> respuestasDto = consulta.getRespuestas().stream()
                    .map(ConsultaMapper::toJerarquicoDto)
                    .collect(Collectors.toList());
            dto.setRespuestas(respuestasDto);
        }
        return dto;
    }

    public static List<ConsultaConRespuestaDto> toDtoList(List<ConsultaEntity> consultas, Long idProfesor) {
        return consultas.stream()
                .map(c -> toDto(c, idProfesor))
                .collect(Collectors.toList());
    }

    public static List<ConsultaJerarquicaDto> toJerarquicoDtoList(List<ConsultaEntity> consultas) {
        return consultas.stream()
                .map(ConsultaMapper::toJerarquicoDto)
                .collect(Collectors.toList());
    }

    public static ConsultaResponseDto toResponseDto(ConsultaEntity consulta) {
        if (consulta == null) return null;
        ConsultaResponseDto dto = new ConsultaResponseDto();
        dto.setId(consulta.getId());
        dto.setTitulo(consulta.getTitulo());
        dto.setMensaje(consulta.getMensaje());
        dto.setFecha(consulta.getFecha());
        dto.setEstado(Boolean.TRUE.equals(consulta.getEstado()));

        dto.setAutorId(consulta.getAutor() != null ? consulta.getAutor().getId() : null);
        dto.setUnidadAprendizajeId(consulta.getUnidadAprendizaje() != null ? consulta.getUnidadAprendizaje().getId() : null);
        dto.setConsultaPadreId(consulta.getConsultaPadre() != null ? consulta.getConsultaPadre().getId() : null);
        //dto.setRegistroAlumnoId(consulta.getRegistroAlumno() != null ? consulta.getRegistroAlumno().getId() : null);

        return dto;
    }
}
