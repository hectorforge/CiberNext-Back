package pe.edu.cibernext.models;

import pe.edu.cibernext.models.UsuarioEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString(exclude = "usuarios")
@Entity
@Table(name = "Rol")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String nombre;

    // Un rol puede estar asociado a muchos usuarios
    @OneToMany(mappedBy = "rol")
    private Set<UsuarioEntity> usuarios;
}
