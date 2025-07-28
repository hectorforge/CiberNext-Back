package pe.edu.cibernext.mapper;

import pe.edu.cibernext.models.RolEntity;
import pe.edu.cibernext.models.UsuarioEntity;
import pe.edu.cibernext.models.dto.RolConUsuariosDto;
import pe.edu.cibernext.models.dto.RolDto;
import pe.edu.cibernext.models.dto.UsuarioSinRolDto;

import java.util.List;
import java.util.stream.Collectors;

public class RolMapper {
    // Para registrar y actualizar
    public static RolDto toDto(RolEntity entity) {
        RolDto dto = new RolDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        return dto;
    }

    public static RolEntity toEntity(RolDto dto) {
        RolEntity entity = new RolEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        return entity;
    }

    public static List<RolDto> toDtoList(List<RolEntity> entities) {
        return entities.stream()
                .map(RolMapper::toDto)
                .collect(Collectors.toList());
    }

    // Para listar con usuarios
    public static RolConUsuariosDto toConUsuariosDto(RolEntity entity) {
        RolConUsuariosDto dto = new RolConUsuariosDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());

        if (entity.getUsuarios() != null) {
            dto.setUsuarios(entity.getUsuarios().stream()
                    .map(RolMapper::mapUsuarioSinRol)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public static List<RolConUsuariosDto> toConUsuariosDtoList(List<RolEntity> entities) {
        return entities.stream().map(RolMapper::toConUsuariosDto).collect(Collectors.toList());
    }

    private static UsuarioSinRolDto mapUsuarioSinRol(UsuarioEntity usuario) {
        UsuarioSinRolDto dto = new UsuarioSinRolDto();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setDni(usuario.getDni());
        dto.setCorreo(usuario.getCorreo());
        return dto;
    }
}
