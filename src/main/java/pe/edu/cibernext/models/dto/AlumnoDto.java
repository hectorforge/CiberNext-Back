package pe.edu.cibernext.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AlumnoDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;
    private String password;
    private String fotoPerfil;
    private String codigoAlumno;
    private String correoPersonal;
    private String pais;

    private Long rolId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String rolNombre;
}