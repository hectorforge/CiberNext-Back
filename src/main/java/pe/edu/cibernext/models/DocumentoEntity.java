package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString(exclude = {"tipoDocumento", "unidadAprendizaje"})
@EqualsAndHashCode(exclude = {"tipoDocumento", "unidadAprendizaje" })
@Entity
@Table(name = "Documento")
public class DocumentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, length = 512)
    private String archivo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    // Relaciones .............................................................

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_documento_id")
    private TipoDocumentoEntity tipoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidad_aprendizaje_id", nullable = false)
    private UnidadAprendizajeEntity unidadAprendizaje;
}