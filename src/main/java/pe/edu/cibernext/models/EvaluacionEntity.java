package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "Evaluacion")
public class EvaluacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private Integer tiempo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidad_aprendizaje_id", unique = true)
    private UnidadAprendizajeEntity unidadAprendizaje;

    @OneToMany(mappedBy = "evaluacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PreguntaEntity> preguntas;
}