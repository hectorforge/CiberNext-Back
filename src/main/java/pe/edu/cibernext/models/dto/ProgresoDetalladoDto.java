package pe.edu.cibernext.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgresoDetalladoDto {
    private int totalUnidades;
    private int totalDocumentos;
    private int totalIntentosEvaluacion;
    private double porcentajeAvance;
}