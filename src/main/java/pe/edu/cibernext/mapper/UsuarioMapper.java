package pe.edu.cibernext.mapper;

import pe.edu.cibernext.models.*;
import pe.edu.cibernext.models.dto.UsuarioDto;
import pe.edu.cibernext.models.dto.UsuarioRegistroDto;
import pe.edu.cibernext.models.enums.Roles;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UsuarioMapper {

    public static UsuarioDto toDto(UsuarioEntity entity) {
        UsuarioDto dto = new UsuarioDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDni(entity.getDni());
        dto.setCorreo(entity.getEmail());
        dto.setFotoPerfil(entity.getFotoPerfil());

        if (entity.getRoles() != null && !entity.getRoles().isEmpty()) {
            dto.setNombresRol(
                    entity.getRoles().stream()
                            .map(RolEntity::getNombre)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }

    public static UsuarioEntity toEntity(UsuarioDto dto) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setEmail(dto.getCorreo());
        entity.setDni(dto.getDni());
        entity.setFotoPerfil(dto.getFotoPerfil());

        if (dto.getNombresRol() != null && !dto.getNombresRol().isEmpty()) {
            String primerRolNombre = dto.getNombresRol().get(0);
            Roles rolEnum = Roles.valueOf(primerRolNombre.toUpperCase());

            RolEntity rol = new RolEntity();
            rol.setId(rolEnum.getCodigo());
            rol.setNombre(rolEnum.name());

            entity.setRoles(Set.of(rol));
        }

        return entity;
    }

    public static UsuarioEntity toEntity(UsuarioRegistroDto dto, RolEntity rol) {
        UsuarioEntity entity;

        if (rol.getId().equals(Roles.ALUMNO.getCodigo())) {
            entity = new AlumnoEntity();
        } else if (rol.getId().equals(Roles.PROFESOR.getCodigo())) {
            entity = new ProfesorEntity();
        } else if (rol.getId().equals(Roles.ADMIN.getCodigo())) {
            entity = new AdministradorEntity();
        } else {
            throw new RuntimeException("Rol desconocido: " + rol.getNombre());
        }

        entity.setNombre(dto.getNombre());
        entity.setEmail(dto.getCorreo());
        entity.setDni(dto.getDni());
        entity.setPassword(dto.getPassword());
        entity.setFotoPerfil(dto.getFotoPerfil());
        entity.setRoles(Set.of(rol));

        return entity;
    }

    public static List<UsuarioDto> toDtoList(List<UsuarioEntity> entities) {
        return entities.stream()
                .map(UsuarioMapper::toDto)
                .collect(Collectors.toList());
    }

}
