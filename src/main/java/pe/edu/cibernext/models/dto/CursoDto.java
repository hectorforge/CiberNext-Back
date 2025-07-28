package pe.edu.cibernext.models.dto;

import lombok.Data;

@Data
public class CursoDto {
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
}