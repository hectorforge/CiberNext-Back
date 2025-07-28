package pe.edu.cibernext.models.dto;

import lombok.Data;

@Data
public class DocumentoRespuestaDto {
    private Long id;
    private String nombre;
    private String archivo;
    private String descripcion;
    private UnidadAprendizajeDto unidadAprendizaje;
    private TipoDocumentoDto tipoDocumento;
}