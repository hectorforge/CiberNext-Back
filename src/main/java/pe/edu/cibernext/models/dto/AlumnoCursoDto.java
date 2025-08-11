package pe.edu.cibernext.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoCursoDto {
    private Long idAlumno;
    private String codigoAlumno;
    private String nombre;
    private String apellido;
    private String email;
    private String pais;
    private String fotoPerfil;
    private String dni;
}