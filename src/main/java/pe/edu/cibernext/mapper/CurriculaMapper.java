package pe.edu.cibernext.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.edu.cibernext.models.AreaEspecializacionEntity;
import pe.edu.cibernext.models.CurriculaEntity;
import pe.edu.cibernext.models.CursoEntity;
import pe.edu.cibernext.models.dto.CurriculaDto;
import pe.edu.cibernext.models.dto.CurriculaRespuestaDto;

@Component
@RequiredArgsConstructor
public class CurriculaMapper {

    private final CursoMapper cursoMapper;
    private final AreaEspecializacionMapper areaMapper;

    public CurriculaDto toDto(CurriculaEntity entity) {
        CurriculaDto dto = new CurriculaDto();
        dto.setId(entity.getId());
        dto.setDescripcion(entity.getDescripcion());
        dto.setOrden(entity.getOrden());
        dto.setCursoId(entity.getCurso().getId());
        dto.setAreaEspecializacionId(entity.getAreaEspecializacion().getId());
        return dto;
    }

    public CurriculaRespuestaDto toRespuestaDto(CurriculaEntity entity) {
        CurriculaRespuestaDto dto = new CurriculaRespuestaDto();
        dto.setId(entity.getId());
        dto.setDescripcion(entity.getDescripcion());
        dto.setOrden(entity.getOrden());
        dto.setCurso(cursoMapper.toDto(entity.getCurso()));
        dto.setAreaEspecializacion(areaMapper.toDto(entity.getAreaEspecializacion()));
        return dto;
    }

    public CurriculaEntity toEntity(CurriculaDto dto, CursoEntity curso, AreaEspecializacionEntity area) {
        CurriculaEntity entity = new CurriculaEntity();
        entity.setId(dto.getId());
        entity.setDescripcion(dto.getDescripcion());
        entity.setOrden(dto.getOrden());
        entity.setCurso(curso);
        entity.setAreaEspecializacion(area);
        return entity;
    }
}
