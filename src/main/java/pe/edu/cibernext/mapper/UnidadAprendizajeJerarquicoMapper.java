package pe.edu.cibernext.mapper;

import pe.edu.cibernext.models.UnidadAprendizajeEntity;
import pe.edu.cibernext.models.dto.UnidadAprendizajeJerarquicoDto;

import java.util.List;
import java.util.stream.Collectors;

public class UnidadAprendizajeJerarquicoMapper {

    public static UnidadAprendizajeJerarquicoDto toDto(UnidadAprendizajeEntity entity) {
        UnidadAprendizajeJerarquicoDto dto = new UnidadAprendizajeJerarquicoDto();
        /*dto.setId(entity.getId());*/
        dto.setNombre(entity.getNombre());
        if (entity.getSubUnidades() != null) {
            dto.setSubUnidades(
                    entity.getSubUnidades().stream()
                            .map(UnidadAprendizajeJerarquicoMapper::toDto)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }

    public static List<UnidadAprendizajeJerarquicoDto> toDtoList(List<UnidadAprendizajeEntity> entities) {
        return entities.stream()
                .map(UnidadAprendizajeJerarquicoMapper::toDto)
                .collect(Collectors.toList());
    }
}
