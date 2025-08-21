package pe.edu.cibernext.models.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DocumentoDto {
    private Long id;
    private String nombre;
    private String archivo;
    private String descripcion;

    private Long idTipoDocumento;


    // Estos se llenan solo al responder
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String nombreTipoDucumento;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String extensionTipoDocumento;

    private Long idUnidadAprendizaje;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String nombreUnidadaprendizaje;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String codigoUnidadaprendizaje;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String descripcionUnidadaprendizaje;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String estadoUnidadaprendizaje;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long cursoId;
}

