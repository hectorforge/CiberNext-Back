package pe.edu.cibernext.models.dto;

import lombok.Data;

@Data
public class UsuarioRegistroDto {
    private String nombre;
    //private String apellido;
    private String dni;
    //private String telefono;
    private String correo;
    private String fotoPerfil;
    private String password;
    private Long rolId;
}
