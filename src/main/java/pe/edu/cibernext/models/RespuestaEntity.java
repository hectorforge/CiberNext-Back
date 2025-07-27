package pe.edu.cibernext.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

import lombok.*;

@Getter
@Setter
@ToString(exclude = {"pregunta", "intentosRespuestas"})
@EqualsAndHashCode(exclude = {"pregunta", "intentosRespuestas"})
@Entity
@Table(name = "Respuesta")
public class RespuestaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String descripcion;

    @Column(precision = 5, scale = 2)
    private BigDecimal valor;

    // Relaciones .............................................................

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pregunta_id", nullable = false)
    private PreguntaEntity pregunta;

    @OneToMany(mappedBy = "respuesta", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IntentoRespuestaEntity> intentosRespuestas;
}