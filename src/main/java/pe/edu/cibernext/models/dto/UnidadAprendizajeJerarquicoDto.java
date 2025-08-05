package pe.edu.cibernext.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class UnidadAprendizajeJerarquicoDto {
    private Long id;
    private String nombre;
    private String descripcion;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<UnidadAprendizajeJerarquicoDto> subUnidades;
}
