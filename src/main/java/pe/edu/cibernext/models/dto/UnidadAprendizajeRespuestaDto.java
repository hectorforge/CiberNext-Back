package pe.edu.cibernext.models.dto;

import lombok.Data;

@Data
public class UnidadAprendizajeRespuestaDto {
    private Long id;
    private String nombre;
    private String codigo;
    private String descripcion;
    private String estado;
    private CursoDto curso;
}