package pe.edu.cibernext.mapper;


import org.springframework.stereotype.Component;
import pe.edu.cibernext.models.TipoDocumentoEntity;
import pe.edu.cibernext.models.dto.TipoDocumentoDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TipoDocumentoMapper {

    public TipoDocumentoDto toDto(TipoDocumentoEntity entity) {
        TipoDocumentoDto dto = new TipoDocumentoDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setExtension(entity.getExtension());
        return dto;
    }

    public TipoDocumentoEntity toEntity(TipoDocumentoDto dto) {
        TipoDocumentoEntity entity = new TipoDocumentoEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setExtension(dto.getExtension());
        return entity;
    }

    public List<TipoDocumentoDto> toDtoList(List<TipoDocumentoEntity> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}