package pe.edu.cibernext.mapper;

import pe.edu.cibernext.models.AlumnoEntity;
import pe.edu.cibernext.models.CursoEntity;
import pe.edu.cibernext.models.dto.AlumnoSimpleDto;
import pe.edu.cibernext.models.dto.CursoDto;

import java.util.ArrayList;
import java.util.List;

public class AlumnoMapper {

    public static AlumnoSimpleDto toSimpleDto(AlumnoEntity e) {
        if (e == null) return null;
        AlumnoSimpleDto dto = new AlumnoSimpleDto();
        dto.setId(e.getId());
        dto.setNombre(e.getNombre());
        dto.setDni(e.getDni());
        dto.setCorreo(e.getEmail());
        dto.setFotoPerfil(e.getFotoPerfil());
        dto.setCodigoAlumno(e.getCodigoAlumno());
        dto.setCorreoPersonal(e.getCorreoPersonal());
        dto.setPais(e.getPais());
        return dto;
    }

    public static void updateEntityFromSimpleDto(AlumnoSimpleDto dto, AlumnoEntity e) {
        if (dto == null || e == null) return;
        if (dto.getNombre() != null)      e.setNombre(dto.getNombre());
        if (dto.getDni() != null)         e.setDni(dto.getDni());
        if (dto.getCorreo() != null)      e.setEmail(dto.getCorreo());
        if (dto.getFotoPerfil() != null)  e.setFotoPerfil(dto.getFotoPerfil());
        if (dto.getCodigoAlumno() != null)   e.setCodigoAlumno(dto.getCodigoAlumno());
        if (dto.getCorreoPersonal() != null) e.setCorreoPersonal(dto.getCorreoPersonal());
        if (dto.getPais() != null)           e.setPais(dto.getPais());
    }

    public static List<CursoDto> toCursosDto(List<CursoEntity> cursos) {
        List<CursoDto> out = new ArrayList<>();
        if (cursos == null) return out;
        for (CursoEntity c : cursos) {
            out.add(CursoMapper.toDto(c));
        }
        return out;
    }
}