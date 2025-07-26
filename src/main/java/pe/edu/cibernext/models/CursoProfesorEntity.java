package pe.edu.cibernext.models;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CursoProfesor")
public class CursoProfesorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", nullable = false)
    private CursoEntity curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_usuario_id", nullable = false)
    private ProfesorEntity profesor;
}