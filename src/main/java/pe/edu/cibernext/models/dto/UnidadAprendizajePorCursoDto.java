package pe.edu.cibernext.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnidadAprendizajePorCursoDto {
    private Long id;
    private String nombre;
    private String descripcion;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<UnidadAprendizajePorCursoDto> subUnidades = new ArrayList<>();
}
