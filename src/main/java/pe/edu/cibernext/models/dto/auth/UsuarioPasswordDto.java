package pe.edu.cibernext.models.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioPasswordDto {

    @NotBlank(message = "La contraseña actual es obligatoria")
    private String actualPassword;

    @NotBlank(message = "La nueva contraseña es obligatoria")
    @Size(min = 6, max = 20, message = "La nueva contraseña debe tener entre 6 y 20 caracteres")
    private String nuevaPassword;

    @NotBlank(message = "Debe confirmar la nueva contraseña")
    private String confirmarPassword;
}