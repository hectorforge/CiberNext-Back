package pe.edu.cibernext.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioDto {
    private Long id;
    private String nombre;
    private String dni;
    private String correo;
    private String fotoPerfil;
    private List<String> nombresRol;

}
