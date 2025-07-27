package pe.edu.cibernext.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class RolConUsuariosDto {
    private Long id;
    private String nombre;
    private List<UsuarioSinRolDto> usuarios;
}