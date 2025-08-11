package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = "registros")
@EqualsAndHashCode(exclude = "registros", callSuper = true)
@Entity
@Table(name = "Alumno")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class AlumnoEntity extends UsuarioEntity {

    @Column(name = "codigo_alumno", unique = true, length = 20)
    private String codigoAlumno;

    @Column(name = "correo_personal", length = 100)
    private String correoPersonal; // TODO: Sugeriria de que aqui sea correoInstitucional ya que el personal ya lo guardamos en el campo "email" del UsuarioEntity

    @Column(name = "pais", length = 100)
    private String pais;

    // Relaciones .............................................................

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RegistroAlumnoEntity> registros = new HashSet<>();

}