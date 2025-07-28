package pe.edu.cibernext.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvanceResponse {
    private long porcentajeAvance;
    private long totalUnidades;
    private long unidadesVistas;
}