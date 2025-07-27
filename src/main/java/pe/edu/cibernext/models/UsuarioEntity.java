package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString(exclude = "rol")
@EqualsAndHashCode(exclude = "rol")
@Entity
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.JOINED) // Estrategia de herencia clave
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false, length = 20)
    private String dni;

    @Column(unique = true, nullable = false)
    private String correo;

    @Column(nullable = false)
    private String password;

    // Relaciones .............................................................

    @ManyToOne(fetch = FetchType.EAGER) // Eager para que el rol se cargue siempre con el usuario
    @JoinColumn(name = "rol_id", nullable = false)
    private RolEntity rol;
}