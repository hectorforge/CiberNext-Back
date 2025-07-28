package pe.edu.cibernext.models.dto;


import lombok.Data;

@Data
public class DocumentoDto {
    private Long id;
    private String nombre;
    private String archivo;
    private String descripcion;
    private Long unidadAprendizajeId;
    private Long tipoDocumentoId;
}
