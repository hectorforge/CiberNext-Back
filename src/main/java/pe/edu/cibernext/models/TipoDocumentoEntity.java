package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TipoDocumento")
public class TipoDocumentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    private String extension;
}