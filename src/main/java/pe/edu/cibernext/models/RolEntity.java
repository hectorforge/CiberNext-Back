package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString(exclude = "usuarios")
@EqualsAndHashCode(exclude = "usuarios")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Rol")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String nombre;
}
