package pe.edu.cibernext.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CursoDocumentoDto {

    private Long cursoId;
    private String cursoCodigo;
    private String cursoNombre;
    private String cursoDescripcion;

    private Long unidadId;
    private String unidadNombre;
    private String unidadCodigo;
    private String unidadDescripcion;
    private String unidadEstado;

    private Long documentoId;
    private String documentoNombre;
    private String documentoArchivo;
    private String documentoDescripcion;

    private Long tipoDocumentoId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String tipoDocumentoNombre;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String tipoDocumentoExtension;
}
