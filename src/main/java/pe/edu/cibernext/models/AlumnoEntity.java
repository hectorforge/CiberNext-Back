package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = "registros")
@EqualsAndHashCode(exclude = "registros", callSuper = true)
@Entity
@Table(name = "Alumno")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class AlumnoEntity extends UsuarioEntity {

    // Relaciones .............................................................

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RegistroAlumnoEntity> registros = new HashSet<>();

}