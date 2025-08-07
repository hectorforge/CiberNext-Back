package pe.edu.cibernext.services;

import org.springframework.stereotype.Component;
import pe.edu.cibernext.models.UsuarioEntity;
import pe.edu.cibernext.models.dto.auth.UsuarioLoginDto;
import pe.edu.cibernext.models.dto.auth.UsuarioPasswordDto;
import pe.edu.cibernext.models.dto.auth.UsuarioRegisterDto;
import pe.edu.cibernext.models.dto.auth.UsuarioUpdateDto;

@Component
public interface AuthService {
    UsuarioEntity register(UsuarioRegisterDto usuario);
    UsuarioEntity login(UsuarioLoginDto usuario);
    String generatePasswordInitial();

    UsuarioEntity updateProfile(String email, UsuarioUpdateDto dto);
    void changePassword(String email, UsuarioPasswordDto dto);
}