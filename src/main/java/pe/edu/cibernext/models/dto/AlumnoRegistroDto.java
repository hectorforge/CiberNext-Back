package pe.edu.cibernext.models.dto;
import lombok.Data;

@Data
public class AlumnoRegistroDto {
    private String nombre;
    private String dni;
    private String correo;
    private String password;
    private Long rolId;
}