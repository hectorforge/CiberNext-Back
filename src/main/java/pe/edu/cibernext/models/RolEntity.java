package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString(exclude = "usuarios")
@EqualsAndHashCode(exclude = "usuarios")
@Entity
@Table(name = "Rol")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String nombre;

    // Relaciones .............................................................

    @OneToMany(mappedBy = "rol")
    private Set<UsuarioEntity> usuarios;
}
