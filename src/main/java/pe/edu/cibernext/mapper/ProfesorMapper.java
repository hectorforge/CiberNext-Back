package pe.edu.cibernext.mapper;

import pe.edu.cibernext.models.ProfesorEntity;
import pe.edu.cibernext.models.RolEntity;
import pe.edu.cibernext.models.dto.ProfesorDto;

public class ProfesorMapper {

    public static ProfesorDto toDto(ProfesorEntity profesorEntity) {
        if (profesorEntity == null) {
            return null;
        }

        ProfesorDto dto = new ProfesorDto();
        dto.setId(profesorEntity.getId());
        dto.setNombre(profesorEntity.getNombre());
        dto.setApellido(profesorEntity.getApellido());
        dto.setDni(profesorEntity.getDni());
        dto.setTelefono(profesorEntity.getTelefono());
        dto.setEmail(profesorEntity.getEmail());
        dto.setCodigoProfesor(profesorEntity.getCodigoProfesor());
        dto.setCorreoProfesional(profesorEntity.getCorreoProfesional());
        dto.setBiografia(profesorEntity.getBiografia());
        dto.setFotoPerfil(profesorEntity.getFotoPerfil());

        if (profesorEntity.getRoles() != null && !profesorEntity.getRoles().isEmpty()) {
            RolEntity rol = profesorEntity.getRoles().iterator().next();
            dto.setRolId(rol.getId());
            dto.setRolNombre(rol.getNombre());
        }

        return dto;
    }

    public static ProfesorEntity toEntity(ProfesorDto profesorDto) {
        if (profesorDto == null) {
            return null;
        }

        ProfesorEntity entity = new ProfesorEntity();
        entity.setId(profesorDto.getId());
        entity.setNombre(profesorDto.getNombre());
        entity.setApellido(profesorDto.getApellido());
        entity.setDni(profesorDto.getDni());
        entity.setTelefono(profesorDto.getTelefono());
        entity.setEmail(profesorDto.getEmail());
        entity.setCodigoProfesor(profesorDto.getCodigoProfesor());
        entity.setCorreoProfesional(profesorDto.getCorreoProfesional());
        entity.setBiografia(profesorDto.getBiografia());
        entity.setFotoPerfil(profesorDto.getFotoPerfil());

        return entity;
    }
}
