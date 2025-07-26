package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_documento_id")
    private TipoDocumentoEntity tipoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidad_aprendizaje_id", nullable = false)
    private UnidadAprendizajeEntity unidadAprendizaje;
}