package pe.edu.cibernext.models.dto;

import lombok.Data;

@Data
public class ConsultaConRespuestaDto {
    private Long id;
    private String titulo;
    private String mensaje;
    private String respuesta; // ← solo si existe
    private String fecha;
    private String nombreAlumno; // opcional
    private String unidad;
}