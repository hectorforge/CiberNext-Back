package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "UnidadAprendizaje")
public class UnidadAprendizajeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String codigo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", nullable = false)
    private CursoEntity curso;

    // Relación jerárquica (padre-hijo)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPadre")
    private UnidadAprendizajeEntity padre;

    @OneToMany(mappedBy = "padre")
    private Set<UnidadAprendizajeEntity> subUnidades;

    // Relación secuencial (lista enlazada)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAnterior", unique = true)
    private UnidadAprendizajeEntity anterior;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSiguiente", unique = true)
    private UnidadAprendizajeEntity siguiente;
}