package pe.edu.cibernext.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.exceptions.RecursoNoEncontradoException;
import pe.edu.cibernext.mapper.AlumnoMapper;
import pe.edu.cibernext.mapper.CursoMapper;
import pe.edu.cibernext.models.AlumnoEntity;
import pe.edu.cibernext.models.CursoEntity;
import pe.edu.cibernext.models.RolEntity;
import pe.edu.cibernext.models.dto.AlumnoDto;
import pe.edu.cibernext.models.dto.CursoDto;
import pe.edu.cibernext.repositories.AlumnoRepository;
import pe.edu.cibernext.repositories.CursoRepository;
import pe.edu.cibernext.repositories.RolRepository;
import pe.edu.cibernext.services.AlumnoService;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final RolRepository rolRepository;
    private final CursoRepository cursoRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailSenderService emailSenderService;

    @Value("${spring.application.name}")
    private String nombreApp;

    @Override
    public AlumnoDto buscarPorId(Long id) {
        AlumnoEntity alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Alumno no encontrado con ID: " + id));
        return AlumnoMapper.toDto(alumno);
    }

    @Override
    public boolean verificarExistenciaPorId(Long id) {
        return alumnoRepository.existsById(id);
    }

    @Override
    public List<AlumnoDto> listarTodos() {
        return alumnoRepository.findAll()
                .stream()
                .map(AlumnoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AlumnoDto registrar(AlumnoDto dto) {
        RolEntity rol = rolRepository.findById(dto.getRolId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Rol no encontrado con ID: " + dto.getRolId()));

        if (!"ALUMNO".equalsIgnoreCase(rol.getNombre())) {
            throw new IllegalArgumentException("El rol asignado no es válido para un Alumno.");
        }

        AlumnoEntity alumno = AlumnoMapper.toEntity(dto);

        String passwordInicial = UUID.randomUUID().toString().substring(0, 6);
        String passwordEncriptada = passwordEncoder.encode(passwordInicial);
        alumno.setPassword(passwordEncriptada);

        alumno.setRoles(new HashSet<>(List.of(rol)));

        AlumnoEntity guardado = alumnoRepository.save(alumno);

        emailSenderService.enviarEmail(
                guardado.getEmail(),
                "Tu cuenta en " + nombreApp + " ha sido creada correctamente. Aquí tienes tu contraseña inicial para acceder a la plataforma.",
                guardado.getNombre(),
                passwordInicial
        );

        return AlumnoMapper.toDto(guardado);
    }

    @Override
    public AlumnoDto actualizar(Long id, AlumnoDto dto) {
        AlumnoEntity alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Alumno no encontrado con ID: " + id));

        alumno.setNombre(dto.getNombre());
        alumno.setApellido(dto.getApellido());
        alumno.setDni(dto.getDni());
        alumno.setTelefono(dto.getTelefono());
        alumno.setEmail(dto.getEmail());
        alumno.setCodigoAlumno(dto.getCodigoAlumno());
        alumno.setCorreoInstitucional(dto.getCorreoPersonal());
        alumno.setPais(dto.getPais());
        alumno.setFotoPerfil(dto.getFotoPerfil());

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            alumno.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        if (dto.getRolId() != null) {
            RolEntity rol = rolRepository.findById(dto.getRolId())
                    .orElseThrow(() -> new RecursoNoEncontradoException("Rol no encontrado con ID: " + dto.getRolId()));

            if (!"ALUMNO".equalsIgnoreCase(rol.getNombre())) {
                throw new IllegalArgumentException("El rol asignado no es válido para un Alumno.");
            }

            alumno.setRoles(new HashSet<>(List.of(rol)));
        }

        AlumnoEntity actualizado = alumnoRepository.save(alumno);
        return AlumnoMapper.toDto(actualizado);
    }


    @Override
    public void eliminarPorId(Long id) {
        if (!alumnoRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Alumno no encontrado con ID: " + id);
        }
        alumnoRepository.deleteById(id);
    }

    @Override
    public List<CursoDto> listarCursos(Long idAlumno) {
        if (!alumnoRepository.existsById(idAlumno)) {
            throw new RecursoNoEncontradoException("Alumno no encontrado con ID: " + idAlumno);
        }
        List<CursoEntity> cursos = alumnoRepository.listarCursosPorAlumno(idAlumno);
        return CursoMapper.toDtoList(cursos);
    }
}
