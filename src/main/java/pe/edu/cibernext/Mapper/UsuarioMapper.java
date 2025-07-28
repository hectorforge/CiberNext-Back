package pe.edu.cibernext.Mapper;

import pe.edu.cibernext.models.RolEntity;
import pe.edu.cibernext.models.UsuarioEntity;
import pe.edu.cibernext.models.dto.RolDto;
import pe.edu.cibernext.models.dto.UsuarioDto;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {
    public static UsuarioDto toDto(UsuarioEntity entity) {
        UsuarioDto dto = new UsuarioDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDni(entity.getDni());
        dto.setCorreo(entity.getCorreo());

        // Mapeo de Rol completo
        RolDto rolDto = new RolDto();
        rolDto.setId(entity.getRol().getId());
        rolDto.setNombre(entity.getRol().getNombre());
        dto.setRol(rolDto);

        return dto;
    }

    public static UsuarioEntity toEntity(UsuarioDto dto) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setCorreo(dto.getCorreo());
        entity.setDni(dto.getDni());

        if (dto.getRol() != null) {
            RolEntity rol = new RolEntity();
            rol.setId(dto.getRol().getId());
            entity.setRol(rol);
        }

        return entity;
    }


    public static List<UsuarioDto> toDtoList(List<UsuarioEntity> entities) {
        return entities.stream().map(UsuarioMapper::toDto).collect(Collectors.toList());
    }


}
