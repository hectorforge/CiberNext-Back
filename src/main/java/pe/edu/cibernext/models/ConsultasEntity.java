package pe.edu.cibernext.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "Consultas")
public class ConsultasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String mensaje;

    private LocalDateTime fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", nullable = false)
    private CursoEntity curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    // Relación para hilos de foro
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consulta_padre_id")
    private ConsultasEntity consultaPadre;

    @OneToMany(mappedBy = "consultaPadre")
    private Set<ConsultasEntity> respuestas;
}
