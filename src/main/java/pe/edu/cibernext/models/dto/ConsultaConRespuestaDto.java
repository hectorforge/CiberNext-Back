package pe.edu.cibernext.models.dto;

import lombok.Data;

@Data
public class ConsultaConRespuestaDto {
    private Long id;
    private String titulo;
    private String mensaje;
    private String respuesta;
    private String fecha;
    private String nombreAlumno;
    private String unidad;
    private String curso;
}