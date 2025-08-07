package pe.edu.cibernext.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.models.RolEntity;
import pe.edu.cibernext.models.UsuarioEntity;
import pe.edu.cibernext.models.dto.auth.UsuarioLoginDto;
import pe.edu.cibernext.models.dto.auth.UsuarioPasswordDto;
import pe.edu.cibernext.models.dto.auth.UsuarioRegisterDto;
import pe.edu.cibernext.models.dto.auth.UsuarioUpdateDto;
import pe.edu.cibernext.repositories.RolRepository;
import pe.edu.cibernext.repositories.UsuarioRepository;
import pe.edu.cibernext.services.AuthService;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailSenderService emailSenderService;
    private final EmailValidatorService  emailValidatorService;

    @Override
    public UsuarioEntity register(UsuarioRegisterDto dto) {
        if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        if (!emailValidatorService.isValidEmail(dto.getEmail())) {
            throw new RuntimeException("El correo no parece válido o activo");
        }

        String passwordGenerateInitial = generatePasswordInitial();

        var rolUser = rolRepository.findByNombre("USER")
                .orElseGet(() -> {
                    var nuevoRol = new RolEntity();
                    nuevoRol.setNombre("USER");
                    return rolRepository.save(nuevoRol);
                });

        UsuarioEntity nuevoUsuario = UsuarioEntity.builder()
                .nombre(dto.getNombre())
                .email(dto.getEmail())
                .dni(dto.getDni())
                .fotoPerfil(dto.getFotoPerfil())
                .password(passwordEncoder.encode(passwordGenerateInitial))
                .roles(Set.of(rolUser))
                .build();

        usuarioRepository.save(nuevoUsuario);

        emailSenderService.enviarEmail(
                nuevoUsuario.getEmail(),
                "Tu cuenta en SecurityApp ha sido creada correctamente. Aquí tienes tu contraseña inicial para acceder a la plataforma.",
                nuevoUsuario.getNombre(),
                passwordGenerateInitial
        );

        return nuevoUsuario;
    }

    @Override
    public UsuarioEntity login(UsuarioLoginDto dto) {
        UsuarioEntity usuario = usuarioRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Correo no encontrado"));
        if (!passwordEncoder.matches(dto.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }
        return usuario;
    }

    @Override
    public String generatePasswordInitial() {
        return UUID.randomUUID().toString().substring(0, 6);
    }

    @Override
    public UsuarioEntity updateProfile(String email, UsuarioUpdateDto dto) {
        UsuarioEntity usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!dto.getEmail().equalsIgnoreCase(usuario.getEmail())) {
            usuarioRepository.findByEmail(dto.getEmail()).ifPresent(existente -> {
                if (!existente.getId().equals(usuario.getId())) {
                    throw new RuntimeException("El correo ya está registrado por otro usuario");
                }
            });
            if (!emailValidatorService.isValidEmail(dto.getEmail())) {
                throw new RuntimeException("El correo no parece válido o activo");
            }

            usuario.setEmail(dto.getEmail());
        }

        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setDni(dto.getDni());
        usuario.setFotoPerfil(dto.getFotoPerfil());

        return usuarioRepository.save(usuario);
    }

    @Override
    public void changePassword(String email, UsuarioPasswordDto dto) {
        UsuarioEntity usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(dto.getActualPassword(), usuario.getPassword())) {
            throw new RuntimeException("La contraseña actual es incorrecta");
        }

        if (!dto.getNuevaPassword().equals(dto.getConfirmarPassword())) {
            throw new RuntimeException("Las nuevas contraseñas no coinciden");
        }

        usuario.setPassword(passwordEncoder.encode(dto.getNuevaPassword()));
        usuarioRepository.save(usuario);
    }
}