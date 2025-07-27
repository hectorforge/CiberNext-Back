package pe.edu.cibernext.models.dto;

import lombok.Data;

@Data
public class UsuarioSinRolDto {
    private Long id;
    private String nombre;
    private String dni;
    private String correo;
}
