package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "AreaEspecializacion")
public class AreaEspecializacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;
}