package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString(exclude = "documentos")
@EqualsAndHashCode(exclude = "documentos")
@Entity
@Table(name = "TipoDocumento")
public class TipoDocumentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    private String extension;

    // Relaciones .............................................................

    @OneToMany(mappedBy = "tipoDocumento", fetch = FetchType.LAZY)
    private Set<DocumentoEntity> documentos;
}