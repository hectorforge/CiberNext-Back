package pe.edu.cibernext.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.edu.cibernext.models.DocumentoEntity;
import pe.edu.cibernext.models.TipoDocumentoEntity;
import pe.edu.cibernext.models.UnidadAprendizajeEntity;
import pe.edu.cibernext.models.dto.DocumentoDto;
import pe.edu.cibernext.models.dto.DocumentoRespuestaDto;

@Component
@RequiredArgsConstructor
public class DocumentoMapper {

    private final UnidadAprendizajeMapper unidadMapper;
    private final TipoDocumentoMapper tipoMapper;

    public DocumentoDto toDto(DocumentoEntity entity) {
        DocumentoDto dto = new DocumentoDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setArchivo(entity.getArchivo());
        dto.setDescripcion(entity.getDescripcion());
        dto.setUnidadAprendizajeId(entity.getUnidadAprendizaje().getId());
        dto.setTipoDocumentoId(entity.getTipoDocumento().getId());
        return dto;
    }

    public DocumentoRespuestaDto toRespuestaDto(DocumentoEntity entity) {
        DocumentoRespuestaDto dto = new DocumentoRespuestaDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setArchivo(entity.getArchivo());
        dto.setDescripcion(entity.getDescripcion());
        dto.setUnidadAprendizaje(unidadMapper.toDto(entity.getUnidadAprendizaje()));
        dto.setTipoDocumento(tipoMapper.toDto(entity.getTipoDocumento()));
        return dto;
    }

    public DocumentoEntity toEntity(DocumentoDto dto, UnidadAprendizajeEntity unidad, TipoDocumentoEntity tipo) {
        DocumentoEntity entity = new DocumentoEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setArchivo(dto.getArchivo());
        entity.setDescripcion(dto.getDescripcion());
        entity.setUnidadAprendizaje(unidad);
        entity.setTipoDocumento(tipo);
        return entity;
    }
}