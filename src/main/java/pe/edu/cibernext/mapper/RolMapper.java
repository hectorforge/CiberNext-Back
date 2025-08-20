package pe.edu.cibernext.mapper;

import org.springframework.stereotype.Component;
import pe.edu.cibernext.models.RolEntity;
import pe.edu.cibernext.models.dto.RolDto;

@Component
public class RolMapper {

    public RolDto toDto(RolEntity entity) {
        if (entity == null) return null;
        RolDto dto = new RolDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        return dto;
    }

    public RolEntity toEntity(RolDto dto) {
        if (dto == null) return null;
        return RolEntity.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .build();
    }
}