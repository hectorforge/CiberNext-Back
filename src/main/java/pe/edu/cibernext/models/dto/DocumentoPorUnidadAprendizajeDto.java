package pe.edu.cibernext.models.dto;

import lombok.Data;

@Data
public class DocumentoPorUnidadAprendizajeDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private String archivo;

    private Long tipoDocumentoId;
    private String tipoDocumentoNombre;
    private String tipoDocumentoExtension;
}