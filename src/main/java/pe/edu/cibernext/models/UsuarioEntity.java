package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString(exclude = "rol")
@EqualsAndHashCode(exclude = "rol")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.JOINED) // Estrategia de herencia clave
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(unique = true, nullable = false, length = 20)
    private String dni;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "foto_perfil", length = 500)
    private String fotoPerfil;

    @Column(nullable = false)
    private String password;

    // Relaciones .............................................................

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<RolEntity> roles;
}