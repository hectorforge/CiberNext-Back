package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString(exclude = "preguntas")
@EqualsAndHashCode(exclude = "preguntas")
@Entity
@Table(name = "TipoPregunta")
public class TipoPreguntaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    // Relaciones .............................................................

    @OneToMany(mappedBy = "tipoPregunta", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PreguntaEntity> preguntas;

}