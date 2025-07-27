package pe.edu.cibernext.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString(exclude = {"curso", "alumno", "profesor", "intentos", "consultas"})
@EqualsAndHashCode(exclude = {"curso", "alumno", "profesor", "intentos", "consultas"})
@Entity
@Table(name = "RegistroAlumno")
public class RegistroAlumnoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaInscripcion;

    // Relaciones .............................................................

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id", nullable = false)
    private CursoEntity curso;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "alumno_usuario_id", nullable = false)
    private AlumnoEntity alumno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profesor_usuario_id", nullable = false)
    private ProfesorEntity profesor;

    @OneToMany(mappedBy = "registroAlumno", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IntentoEntity> intentos;

    @OneToMany(mappedBy = "registroAlumno", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConsultaEntity> consultas;

}