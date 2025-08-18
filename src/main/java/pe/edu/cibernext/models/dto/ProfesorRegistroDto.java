package pe.edu.cibernext.models.dto;

import lombok.Data;

@Data
public class ProfesorRegistroDto {
    private String nombre;
    private String dni;
    private String apellido;
    private String telefono;
    private String correo;
    private String password;
    private String codigoProfesor;
    private String correoProfesional;
    private String biografia;
    private String fotoPerfil;
    private Long rolId;

}

