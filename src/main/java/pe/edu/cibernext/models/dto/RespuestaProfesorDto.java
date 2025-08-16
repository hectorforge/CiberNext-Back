package pe.edu.cibernext.models.dto;

import lombok.Data;

@Data
public class RespuestaProfesorDto {
    private String titulo;
    private String mensaje;
    private Long profesorId;
    private Long consultaPadreId;
}