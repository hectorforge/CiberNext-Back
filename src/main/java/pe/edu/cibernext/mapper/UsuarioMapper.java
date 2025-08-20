package pe.edu.cibernext.mapper;

import org.springframework.stereotype.Component;
import pe.edu.cibernext.models.*;
import pe.edu.cibernext.models.dto.UsuarioDto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    public UsuarioDto toDto(UsuarioEntity entity) {
        if (entity == null) return null;

        UsuarioDto dto = new UsuarioDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setApellido(entity.getApellido());
        dto.setTelefono(entity.getTelefono());
        dto.setDni(entity.getDni());
        dto.setCorreo(entity.getEmail());
        dto.setFotoPerfil(entity.getFotoPerfil());

        // Como ahora solo manejas un rol
        if (entity.getRoles() != null && !entity.getRoles().isEmpty()) {
            RolEntity rol = entity.getRoles().iterator().next();
            dto.setIdRol(rol.getId());
        }

        return dto;
    }

    public UsuarioEntity toEntity(UsuarioDto dto, RolEntity rol) {
        if (dto == null) return null;

        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setTelefono(dto.getTelefono());
        entity.setEmail(dto.getCorreo());
        entity.setDni(dto.getDni());
        entity.setFotoPerfil(dto.getFotoPerfil());

        // Setear rol único
        entity.setRoles(Set.of(rol));

        return entity;
    }

    public List<UsuarioDto> toDtoList(List<UsuarioEntity> entities) {
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}