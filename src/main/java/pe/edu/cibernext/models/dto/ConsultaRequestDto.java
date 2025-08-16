package pe.edu.cibernext.models.dto;

import lombok.Data;

@Data
public class ConsultaRequestDto {
    private String titulo;
    private String mensaje;
    private Long alumnoId;
    private Long unidadAprendizajeId;
}