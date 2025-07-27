package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"curso", "documentos", "consultas", "evaluacion", "padre", "subUnidades", "anterior", "siguiente"})
@EqualsAndHashCode(exclude = {"curso", "documentos", "consultas", "evaluacion", "padre", "subUnidades", "anterior", "siguiente"})
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

    // Relaciones .............................................................

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", nullable = false)
    private CursoEntity curso;

    @OneToMany(mappedBy = "unidadAprendizaje", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DocumentoEntity> documentos;

    @OneToMany(mappedBy = "unidadAprendizaje", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConsultaEntity> consultas;

    @OneToOne(mappedBy = "unidadAprendizaje", cascade = CascadeType.ALL)
    private EvaluacionEntity evaluacion;


    // Relación jerárquica (padre-hijo)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPadre")
    private UnidadAprendizajeEntity padre;

    @OneToMany(mappedBy = "padre")
    private List<UnidadAprendizajeEntity> subUnidades;

    // Relación secuencial (lista enlazada)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAnterior", unique = true)
    private UnidadAprendizajeEntity anterior;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSiguiente", unique = true)
    private UnidadAprendizajeEntity siguiente;

}