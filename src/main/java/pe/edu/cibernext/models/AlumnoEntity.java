package pe.edu.cibernext.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Alumno")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class AlumnoEntity extends UsuarioEntity {
}