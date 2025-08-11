package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString(exclude = {"curso", "areaEspecializacion"})
@EqualsAndHashCode(exclude = {"curso", "areaEspecializacion"})
@Entity
@Table(name = "Curricula")
public class CurriculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private Integer orden;

    // Relaciones .............................................................

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", nullable = false)
    private CursoEntity curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_especializacion_id", nullable = false)
    private AreaEspecializacionEntity areaEspecializacion;
}