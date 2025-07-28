package pe.edu.cibernext.models.dto;

import lombok.Data;

@Data
public class EvaluacionDto {
    private Long id;
    private String descripcion;
    private Integer tiempo;
    private Long unidadAprendizajeId;
}