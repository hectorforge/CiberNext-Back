package pe.edu.cibernext.models.dto;

import lombok.Data;

@Data
public class CurriculaRespuestaDto {
    private Long id;
    private String descripcion;
    private Integer orden;
    private CursoDto curso;
    private AreaEspecializacionDto areaEspecializacion;
}