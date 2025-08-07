package pe.edu.cibernext.mapper;

import pe.edu.cibernext.models.ProfesorEntity;
import pe.edu.cibernext.models.dto.ProfesorDto;

public class ProfesorMapper {
    public static ProfesorDto toDto(ProfesorEntity profesorEntity) {
        if (profesorEntity == null) {
            return null;
        }

        ProfesorDto dto = new ProfesorDto();
        dto.setId(profesorEntity.getId());
        dto.setNombre(profesorEntity.getNombre());
        dto.setDni(profesorEntity.getDni());
        dto.setCorreo(profesorEntity.getEmail());
        dto.setRol(profesorEntity.getRoles());
        dto.setCodigoProfesor(profesorEntity.getCodigoProfesor());
        dto.setCorreoProfesional(profesorEntity.getCorreoProfesional());
        dto.setBiografia(profesorEntity.getBiografia());
        dto.setFotoPerfil(profesorEntity.getFotoPerfil());
        return dto;
    }
    public static ProfesorEntity toEntity(ProfesorDto profesorDto) {
        if (profesorDto == null) {
            return null;
        }

        ProfesorEntity entity = new ProfesorEntity();
        entity.setId(profesorDto.getId());
        entity.setNombre(profesorDto.getNombre());
        entity.setDni(profesorDto.getDni());
        entity.setEmail(profesorDto.getCorreo());
        entity.setRoles(profesorDto.getRol());
        entity.setCodigoProfesor(profesorDto.getCodigoProfesor());
        entity.setCorreoProfesional(profesorDto.getCorreoProfesional());
        entity.setBiografia(profesorDto.getBiografia());
        entity.setFotoPerfil(profesorDto.getFotoPerfil());
        return entity;
    }

}
