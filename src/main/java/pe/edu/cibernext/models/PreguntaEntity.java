package pe.edu.cibernext.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"evaluacion", "tipoPregunta", "respuestas", "intentosRespuestas"})
@EqualsAndHashCode(exclude = {"evaluacion", "tipoPregunta", "respuestas", "intentosRespuestas"})
@Entity
@Table(name = "Pregunta")
public class PreguntaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String descripcion;

    // Relaciones .............................................................

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluacion_id", nullable = false)
    private EvaluacionEntity evaluacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_pregunta_id")
    private TipoPreguntaEntity tipoPregunta;

    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RespuestaEntity> respuestas;

    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IntentoRespuestaEntity> intentosRespuestas;
}