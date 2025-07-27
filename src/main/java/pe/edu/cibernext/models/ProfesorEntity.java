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

    // Relaciones .............................................................

    @ManyToMany(mappedBy = "profesores")
    private Set<CursoEntity> cursos;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RegistroAlumnoEntity> registros = new HashSet<>();

}