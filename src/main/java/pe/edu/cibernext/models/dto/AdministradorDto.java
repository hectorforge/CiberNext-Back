package pe.edu.cibernext.models.dto;

import lombok.Data;

@Data
public class AdministradorDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private String fotoPerfil;
    private String password;
}