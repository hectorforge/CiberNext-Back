package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"cursos", "registros"})
@EqualsAndHashCode(exclude = {"cursos", "registros"}, callSuper = true)
@Entity
@Table(name = "Profesor")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class ProfesorEntity extends UsuarioEntity {


    @Column(name = "codigo_profesor", unique = true, length = 20)
    private String codigoProfesor;

    @Column(name = "correo_profesional", length = 100)
    private String correoProfesional;

    @Column(name = "biografia", columnDefinition = "TEXT")
    private String biografia;

    @Column(name = "foto_perfil", length = 500)
    private String fotoPerfil;

    // Relaciones .............................................................

    @ManyToMany(mappedBy = "profesores")
    private Set<CursoEntity> cursos;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RegistroAlumnoEntity> registros = new HashSet<>();

}