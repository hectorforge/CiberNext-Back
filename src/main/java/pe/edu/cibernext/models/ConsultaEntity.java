package pe.edu.cibernext.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import lombok.*;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
@ToString(exclude = {"autor", "registroAlumno", "unidadAprendizaje", "consultaPadre", "respuestas"})
@EqualsAndHashCode(exclude = {"autor", "registroAlumno", "unidadAprendizaje", "consultaPadre", "respuestas" })
@Entity
@Table(name = "Consultas")
public class ConsultaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String mensaje;

    private LocalDateTime fecha;

    // Relaciones .............................................................

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false) // Siempre presente para saber el autor
    private UsuarioEntity autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registro_alumno_id") // Opcional, solo para el primer post
    @Nullable
    private RegistroAlumnoEntity registroAlumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidad_aprendizaje_id") // Opcional, recomendado colocar siempre
    @Nullable
    private UnidadAprendizajeEntity unidadAprendizaje;

    // Relación jerárquica (padre-hijos)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consulta_padre_id")
    private ConsultaEntity consultaPadre;

    @OneToMany(mappedBy = "consultaPadre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConsultaEntity> respuestas;

}