package pe.edu.cibernext.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Administrador")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class AdministradorEntity extends UsuarioEntity {

}