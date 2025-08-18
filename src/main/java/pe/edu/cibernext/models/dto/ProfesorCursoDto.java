package pe.edu.cibernext.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorCursoDto {
    private Long idProfesor;
    private String codigoProfesor;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String correoProfesional;
    private String biografia;
    private String fotoPerfil;
    private String dni;
}
