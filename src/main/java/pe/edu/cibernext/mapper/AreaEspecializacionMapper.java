package pe.edu.cibernext.mapper;

import org.springframework.stereotype.Component;
import pe.edu.cibernext.models.AreaEspecializacionEntity;
import pe.edu.cibernext.models.dto.AreaEspecializacionDto;

@Component
public class AreaEspecializacionMapper {

    public AreaEspecializacionDto toDto(AreaEspecializacionEntity entity) {
        if (entity == null) return null;

        AreaEspecializacionDto dto = new AreaEspecializacionDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        return dto;
    }

}
