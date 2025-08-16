package pe.edu.cibernext.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.models.AlumnoEntity;
import pe.edu.cibernext.models.RolEntity;
import pe.edu.cibernext.models.UsuarioEntity;
import pe.edu.cibernext.models.dto.auth.UsuarioLoginDto;
import pe.edu.cibernext.models.dto.auth.UsuarioPasswordDto;
import pe.edu.cibernext.models.dto.auth.UsuarioRegisterDto;
import pe.edu.cibernext.models.dto.auth.UsuarioUpdateDto;
import pe.edu.cibernext.repositories.AlumnoRepository;
import pe.edu.cibernext.repositories.RolRepository;
import pe.edu.cibernext.repositories.UsuarioRepository;
import pe.edu.cibernext.services.AuthService;
import pe.edu.cibernext.util.CodeGeneratorRandom;
// import pe.edu.cibernext.services.EmailValidatorService;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    @Value("${spring.application.name}")
    private String nombreApp;

    private final UsuarioRepository usuarioRepository;
    private final AlumnoRepository alumnoRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailSenderService emailSenderService;
    private final EmailValidatorService emailValidatorService;


    @Override
    public UsuarioEntity register(UsuarioRegisterDto dto) {

        if (usuarioRepository.findByDni(dto.getDni()).isPresent()) {
            throw new RuntimeException("El DNI ya existe");
        }

        if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        if (!emailValidatorService.isValidEmail(dto.getEmail())) {
            throw new RuntimeException("El correo no parece válido o activo");
        }

        String passwordGenerateInitial = generatePasswordInitial();

        var rolAlumno = rolRepository.findByNombre("ALUMNO")
                .orElseGet(() -> {
                    var nuevoRol = new RolEntity();
                    nuevoRol.setNombre("ALUMNO");
                    return rolRepository.save(nuevoRol);
                });

        String fotoPerfil = (dto.getFotoPerfil() == null || dto.getFotoPerfil().isBlank())
                ? "https://static.vecteezy.com/system/resources/previews/012/742/173/large_2x/unknow-person-icon-free-vector.jpg"
                : dto.getFotoPerfil();

        long totalAlumnos = alumnoRepository.count();
        String codigoAlumno = CodeGeneratorRandom.generarCodigoUnico("A", totalAlumnos);
        String correoInstitucional = codigoAlumno.toLowerCase() + "@cibernext.edu.pe";

        AlumnoEntity alumno = new AlumnoEntity();
        alumno.setNombre(dto.getNombre());
        alumno.setPais(dto.getPais());
        alumno.setTelefono(dto.getNumero());
        alumno.setApellido(dto.getApellido());
        alumno.setEmail(dto.getEmail());
        alumno.setDni(dto.getDni());
        alumno.setFotoPerfil(fotoPerfil);
        alumno.setPassword(passwordEncoder.encode(passwordGenerateInitial));
        alumno.setRoles(Set.of(rolAlumno));
        alumno.setCodigoAlumno(codigoAlumno);
        alumno.setCorreoInstitucional(correoInstitucional);

        alumnoRepository.save(alumno);

        emailSenderService.enviarEmail(
                alumno.getEmail(),
                "Tu cuenta en " + nombreApp + " ha sido creada correctamente. Aquí tienes tu contraseña inicial para acceder a la plataforma.",
                alumno.getNombre(),
                passwordGenerateInitial
        );

        return alumno;
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

        if (!dto.getDni().equalsIgnoreCase(usuario.getDni())) {
            usuarioRepository.findByDni(dto.getDni()).ifPresent(existente -> {
                if (!existente.getId().equals(usuario.getId())) {
                    throw new RuntimeException("El DNI ya está registrado por otro usuario");
                }
            });

            usuario.setDni(dto.getDni());
        }

        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
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
