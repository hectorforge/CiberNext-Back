package pe.edu.cibernext.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class DocumentosPorCursoDto {
    private Long unidadId;
    private String nombreUnidad;
    private List<DocumentoPorUnidadAprendizajeDto> documentos;
}

