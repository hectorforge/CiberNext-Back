package pe.edu.cibernext.models.dto;

import lombok.Data;
import pe.edu.cibernext.models.RolEntity;

import java.util.Set;

@Data
public class ProfesorDto {
    private Long id;
    private String nombre;
    private String dni;
    private String correo;
    private Set<String> roles;
    private String codigoProfesor;
    private String correoProfesional;
    private String biografia;
    private String fotoPerfil;
}
