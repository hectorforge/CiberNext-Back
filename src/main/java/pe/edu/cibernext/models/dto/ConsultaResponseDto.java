package pe.edu.cibernext.models.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConsultaResponseDto {
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    private boolean estado;
    private Long autorId;
    private String autorNombre;
    private Long unidadAprendizajeId;
    private Long consultaPadreId;
}