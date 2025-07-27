package pe.edu.cibernext.models;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import lombok.*;

@Getter
@Setter
@ToString(exclude = {"evaluacion", "registroAlumno", "respuestas"})
@EqualsAndHashCode(exclude = {"evaluacion", "registroAlumno", "respuestas"})
@Entity
@Table(name = "Intento")
public class IntentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;

    private LocalDateTime fecha;

    @Column(precision = 5, scale = 2)
    private BigDecimal nota;

    // Relaciones .............................................................

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluacion_id", nullable = false)
    private EvaluacionEntity evaluacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registro_alumno_id", nullable = false)
    private RegistroAlumnoEntity registroAlumno;

    @OneToMany(
        mappedBy = "intento",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private Set<IntentoRespuestaEntity> respuestas;

}