package pe.edu.cibernext.models.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CursoAlumnoAvanceDto {
    private long porcentajeAvance;
    private long totalUnidades;
    private long unidadesVistas;
}