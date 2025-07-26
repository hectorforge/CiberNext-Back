package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TipoPregunta")
public class TipoPreguntaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;
}