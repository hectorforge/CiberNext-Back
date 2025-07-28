package pe.edu.cibernext.mapper;

import pe.edu.cibernext.models.CursoEntity;
import pe.edu.cibernext.models.dto.CursoDto;

import java.util.List;
import java.util.stream.Collectors;

public class CursoMapper {
    public static CursoDto toDto(CursoEntity entity) {
        CursoDto dto = new CursoDto();
        dto.setId(entity.getId());
        dto.setCodigo(entity.getCodigo());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        return dto;
    }

    public static CursoEntity toEntity(CursoDto dto) {
        CursoEntity entity = new CursoEntity();
        entity.setId(dto.getId());
        entity.setCodigo(dto.getCodigo());
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        return entity;
    }

    public static List<CursoDto> toDtoList(List<CursoEntity> entities) {
        return entities.stream().map(CursoMapper::toDto).collect(Collectors.toList());
    }
}
