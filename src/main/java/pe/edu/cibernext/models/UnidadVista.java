package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "UnidadVista", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"unidadAprendizajeId", "registroAlumnoId"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnidadVista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long unidadAprendizajeId;

    private Long registroAlumnoId;

    @UpdateTimestamp
    private LocalDateTime fechaVisualizacion = LocalDateTime.now();
}