package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString(exclude = "curriculas")
@EqualsAndHashCode(exclude = "curriculas")
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

    // Relaciones .............................................................

    @OneToMany(mappedBy = "areaEspecializacion", fetch = FetchType.LAZY)
    private List<CurriculaEntity> curriculas;

}