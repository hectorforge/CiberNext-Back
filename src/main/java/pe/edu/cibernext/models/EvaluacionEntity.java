package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.List;

@Getter
@Setter
@ToString(exclude = {"unidadAprendizaje", "preguntas", "intentos"})
@EqualsAndHashCode(exclude = {"unidadAprendizaje", "preguntas", "intentos"})
@Entity
@Table(name = "Evaluacion")
public class EvaluacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private Integer tiempo;

    // Relaciones .............................................................

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidad_aprendizaje_id", referencedColumnName = "id")
    private UnidadAprendizajeEntity unidadAprendizaje;

    @OneToMany(mappedBy = "evaluacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PreguntaEntity> preguntas;

    @OneToMany(mappedBy = "evaluacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IntentoEntity> intentos;
}