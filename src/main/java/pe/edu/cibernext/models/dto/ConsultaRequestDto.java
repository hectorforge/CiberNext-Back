package pe.edu.cibernext.models.dto;

import lombok.Data;

@Data
public class ConsultaRequestDto {
    private String titulo;
    private String mensaje;
    private Long unidadAprendizajeId;

    private Long usuarioId;
    private Long registroAlumnoId;
    private Long consultaPadreId;

    //private Long alumnoId;
}