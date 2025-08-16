package pe.edu.cibernext.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class ConsultaJerarquicaDto {
    private Long id;
    private String titulo;
    private String mensaje;
    private String fecha;
    private String nombreAutor;
    private String unidad;
    private String curso;
    private List<ConsultaJerarquicaDto> respuestas;
}