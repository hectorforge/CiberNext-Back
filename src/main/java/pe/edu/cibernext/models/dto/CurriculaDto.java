package pe.edu.cibernext.models.dto;

import lombok.Data;

@Data
public class CurriculaDto {
    private Long id;
    private String descripcion;
    private Integer orden;
    private Long cursoId;
    private Long areaEspecializacionId;
}