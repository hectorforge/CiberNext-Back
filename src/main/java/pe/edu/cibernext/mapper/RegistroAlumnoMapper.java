package pe.edu.cibernext.mapper;


import pe.edu.cibernext.models.RegistroAlumnoEntity;
import pe.edu.cibernext.models.dto.RegistroAlumnoResponseDto;

public class RegistroAlumnoMapper {

    public static RegistroAlumnoResponseDto toDto(RegistroAlumnoEntity entity) {
        RegistroAlumnoResponseDto dto = new RegistroAlumnoResponseDto();

        dto.setId(entity.getId());
        dto.setFechaInscripcion(entity.getFechaInscripcion());
        dto.setCursoId(entity.getCurso().getId());
        dto.setNombreCurso(entity.getCurso().getNombre());

        dto.setAlumnoId(entity.getAlumno().getId());
        dto.setNombreAlumno(entity.getAlumno().getNombre());
        dto.setCorreoAlumno(entity.getAlumno().getCorreoInstitucional());
        dto.setCodigoAlumno(entity.getAlumno().getCodigoAlumno());

        dto.setProfesorId(entity.getProfesor().getId());
        dto.setNombreProfesor(entity.getProfesor().getNombre());
        dto.setCorreoProfesor(entity.getProfesor().getCorreoProfesional());
        dto.setCodigoProfesor(entity.getProfesor().getCodigoProfesor());

        return dto;
    }
}
