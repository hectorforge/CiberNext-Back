package pe.edu.cibernext.mapper;

import pe.edu.cibernext.models.AlumnoEntity;
import pe.edu.cibernext.models.RolEntity;
import pe.edu.cibernext.models.dto.AlumnoDto;

public class AlumnoMapper {

    public static AlumnoDto toDto(AlumnoEntity e) {
        if (e == null) return null;
        AlumnoDto dto = new AlumnoDto();
        dto.setId(e.getId());
        dto.setNombre(e.getNombre());
        dto.setApellido(e.getApellido());
        dto.setDni(e.getDni());
        dto.setTelefono(e.getTelefono());
        dto.setEmail(e.getEmail());
        dto.setPassword(e.getPassword());
        dto.setFotoPerfil(e.getFotoPerfil());

        dto.setCodigoAlumno(e.getCodigoAlumno());
        dto.setCorreoPersonal(e.getCorreoInstitucional());
        dto.setPais(e.getPais());

        if (e.getRoles() != null && !e.getRoles().isEmpty()) {
            RolEntity rol = e.getRoles().iterator().next();
            dto.setRolId(rol.getId());
            dto.setRolNombre(rol.getNombre());
        }

        return dto;
    }

    public static AlumnoEntity toEntity(AlumnoDto dto) {
        if (dto == null) return null;
        AlumnoEntity e = new AlumnoEntity();
        e.setId(dto.getId());
        e.setNombre(dto.getNombre());
        e.setApellido(dto.getApellido());
        e.setDni(dto.getDni());
        e.setTelefono(dto.getTelefono());
        e.setEmail(dto.getEmail());
        e.setPassword(dto.getPassword());
        e.setFotoPerfil(dto.getFotoPerfil());

        e.setCodigoAlumno(dto.getCodigoAlumno());
        e.setCorreoInstitucional(dto.getCorreoPersonal());
        e.setPais(dto.getPais());

        return e;
    }
}
