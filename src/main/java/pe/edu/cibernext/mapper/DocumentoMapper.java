package pe.edu.cibernext.mapper;

import org.springframework.stereotype.Component;
import pe.edu.cibernext.models.DocumentoEntity;
import pe.edu.cibernext.models.TipoDocumentoEntity;
import pe.edu.cibernext.models.UnidadAprendizajeEntity;
import pe.edu.cibernext.models.dto.DocumentoDto;
@Component
public class DocumentoMapper {

    public DocumentoDto toDto(DocumentoEntity entity) {
        DocumentoDto dto = new DocumentoDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setArchivo(entity.getArchivo());
        dto.setDescripcion(entity.getDescripcion());

        dto.setIdUnidadAprendizaje(entity.getUnidadAprendizaje().getId());
        dto.setIdTipoDocumento(entity.getTipoDocumento().getId());

        dto.setNombreTipoDucumento(entity.getTipoDocumento().getNombre());
        dto.setExtensionTipoDocumento(entity.getTipoDocumento().getExtension());

        dto.setNombreUnidadaprendizaje(entity.getUnidadAprendizaje().getNombre());
        dto.setCodigoUnidadaprendizaje(entity.getUnidadAprendizaje().getCodigo());
        dto.setDescripcionUnidadaprendizaje(entity.getUnidadAprendizaje().getDescripcion());
        dto.setEstadoUnidadaprendizaje(entity.getUnidadAprendizaje().getEstado());
        dto.setCursoId(entity.getUnidadAprendizaje().getCurso().getId());

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