package pe.edu.cibernext.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import pe.edu.cibernext.exceptions.RecursoNoEncontradoException;
import pe.edu.cibernext.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.models.*;
import pe.edu.cibernext.models.dto.UsuarioDto;
import pe.edu.cibernext.repositories.*;
import pe.edu.cibernext.services.UsuarioService;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;
    private final EmailSenderService emailSenderService;

    @Value("${spring.application.name}")
    private String nombreApp;

    @Override
    public UsuarioDto buscarPorId(Long id) {
        UsuarioEntity entity = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Usuario no encontrado con ID: " + id));
        return usuarioMapper.toDto(entity);
    }

    @Override
    public void verificarExistenciaPorId(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("No existe el usuario con ID: " + id);
        }
    }

    @Override
    public List<UsuarioDto> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public UsuarioDto registrar(UsuarioDto dto) {
        // Buscar rol a partir del idRol
        RolEntity rol = rolRepository.findById(dto.getIdRol())
                .orElseThrow(() -> new RecursoNoEncontradoException("Rol no encontrado con ID: " + dto.getIdRol()));

        // Convertir DTO a Entity
        UsuarioEntity entity = usuarioMapper.toEntity(dto, rol);

        // Generar contraseña inicial
        String passwordGenerada = UUID.randomUUID().toString().substring(0, 8);
        String passwordEncriptada = passwordEncoder.encode(passwordGenerada);
        entity.setPassword(passwordEncriptada);

        // Guardar usuario
        UsuarioEntity usuarioGuardado = usuarioRepository.save(entity);

        // Enviar correo
        emailSenderService.enviarEmail(
                usuarioGuardado.getEmail(),
                "Tu cuenta en " + nombreApp + " ha sido creada correctamente. Aquí tienes tu contraseña inicial para acceder a la plataforma.",
                usuarioGuardado.getNombre(),
                passwordGenerada
        );

        return usuarioMapper.toDto(usuarioGuardado);
    }

    @Override
    public UsuarioDto actualizar(UsuarioDto dto) {
        UsuarioEntity entity = usuarioRepository.findById(dto.getId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Usuario no encontrado con ID: " + dto.getId()));

        // Actualizar campos básicos
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setTelefono(dto.getTelefono());
        entity.setEmail(dto.getCorreo());
        entity.setDni(dto.getDni());
        entity.setFotoPerfil(dto.getFotoPerfil());

        // Actualizar rol si se envió uno
        if (dto.getIdRol() != null) {
            RolEntity rol = rolRepository.findById(dto.getIdRol())
                    .orElseThrow(() -> new RecursoNoEncontradoException("Rol no encontrado con ID: " + dto.getIdRol()));
            entity.setRoles(Set.of(rol));
        }

        UsuarioEntity actualizado = usuarioRepository.save(entity);
        return usuarioMapper.toDto(actualizado);
    }
    @Override
    public void eliminarPorId(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Usuario no encontrado con ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<UsuarioDto> buscarPorFiltro(String filtro) {
        return usuarioRepository.buscarPorFiltro(filtro)
                .stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }
}
