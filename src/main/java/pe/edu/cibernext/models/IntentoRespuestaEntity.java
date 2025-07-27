package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString(exclude = {"intento", "pregunta", "respuesta"})
@EqualsAndHashCode(exclude = {"intento", "pregunta", "respuesta"})
@Entity
@Table(name = "IntentoRespuesta")
public class IntentoRespuestaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relaciones .............................................................

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "intento_id", nullable = false)
    private IntentoEntity intento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pregunta_id", nullable = false)
    private PreguntaEntity pregunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "respuesta_id", nullable = false)
    private RespuestaEntity respuesta;
}