package pe.edu.cibernext.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ConsultaPorUnidadAprendizajeDto {
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    private boolean estado;

    // Datos del USUARIO autor (puede ser alumno o profesor porque ambos son Usuario)
    private String autorTipo;
    private Long autorId;
    private String autorNombre;
    private String autorApellido;
    private String autorEmail;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ConsultaPorUnidadAprendizajeDto> respuestas = new ArrayList<>();
}