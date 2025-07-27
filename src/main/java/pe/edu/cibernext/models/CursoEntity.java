package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Getter
@Setter
@ToString(exclude = {"profesores", "unidades", "curriculas", "registrosAlumnos"})
@EqualsAndHashCode(exclude = {"profesores", "unidades", "curriculas", "registrosAlumnos"})
@Entity
@Table(name = "Curso")
public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    // Relaciones .............................................................

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UnidadAprendizajeEntity> unidades;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List<CurriculaEntity> curriculas;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private Set<RegistroAlumnoEntity> registrosAlumnos;

    @ManyToMany
    @JoinTable(
        name = "CursoProfesor",
        joinColumns = @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn(name = "profesor_usuario_id")
    )
    private Set<ProfesorEntity> profesores = new HashSet<>();

}