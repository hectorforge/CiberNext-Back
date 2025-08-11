package pe.edu.cibernext.mapper;

import org.springframework.stereotype.Component;
import pe.edu.cibernext.models.ConsultaEntity;
import pe.edu.cibernext.models.UnidadAprendizajeEntity;
import pe.edu.cibernext.models.dto.ConsultaPorUnidadAprendizajeDto;
import pe.edu.cibernext.models.dto.UnidadAprendizajeJerarquicoDto;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class UnidadAprendizajeJerarquicoMapper {

    public static UnidadAprendizajeJerarquicoDto toDto(UnidadAprendizajeEntity entity) {
        UnidadAprendizajeJerarquicoDto dto = new UnidadAprendizajeJerarquicoDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        if (entity.getSubUnidades() != null) {
            dto.setSubUnidades(
                    entity.getSubUnidades().stream()
                            .map(UnidadAprendizajeJerarquicoMapper::toDto)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }




}
