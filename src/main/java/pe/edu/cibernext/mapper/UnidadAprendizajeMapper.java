package pe.edu.cibernext.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.edu.cibernext.models.CursoEntity;
import pe.edu.cibernext.models.UnidadAprendizajeEntity;
import pe.edu.cibernext.models.dto.UnidadAprendizajeDto;
import pe.edu.cibernext.models.dto.UnidadAprendizajeRespuestaDto;

@Component
@RequiredArgsConstructor
public class UnidadAprendizajeMapper {

    private final CursoMapper cursoMapper;

    public UnidadAprendizajeDto toDto(UnidadAprendizajeEntity entity) {
        UnidadAprendizajeDto dto = new UnidadAprendizajeDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setCodigo(entity.getCodigo());
        dto.setDescripcion(entity.getDescripcion());
        dto.setEstado(entity.getEstado());
        dto.setCursoId(entity.getCurso() != null ? entity.getCurso().getId() : null);
        return dto;
    }

    public UnidadAprendizajeRespuestaDto toRespuestaDto(UnidadAprendizajeEntity entity) {
        UnidadAprendizajeRespuestaDto dto = new UnidadAprendizajeRespuestaDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setCodigo(entity.getCodigo());
        dto.setDescripcion(entity.getDescripcion());
        dto.setEstado(entity.getEstado());
        dto.setCurso(cursoMapper.toDto(entity.getCurso()));
        return dto;
    }

    public UnidadAprendizajeEntity toEntity(UnidadAprendizajeDto dto, CursoEntity curso) {
        UnidadAprendizajeEntity entity = new UnidadAprendizajeEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setCodigo(dto.getCodigo());
        entity.setDescripcion(dto.getDescripcion());
        entity.setEstado(dto.getEstado());
        entity.setCurso(curso);
        return entity;
    }
}