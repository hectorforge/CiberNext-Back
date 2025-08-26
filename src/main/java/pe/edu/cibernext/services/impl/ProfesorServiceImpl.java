package pe.edu.cibernext.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.exceptions.RecursoNoEncontradoException;
import pe.edu.cibernext.mapper.CursoMapper;
import pe.edu.cibernext.mapper.ProfesorMapper;
import pe.edu.cibernext.models.CursoEntity;
import pe.edu.cibernext.models.ProfesorEntity;
import pe.edu.cibernext.models.RolEntity;
import pe.edu.cibernext.models.dto.CursoDto;
import pe.edu.cibernext.models.dto.ProfesorDto;
import pe.edu.cibernext.repositories.CursoRepository;
import pe.edu.cibernext.repositories.ProfesorRepository;
import pe.edu.cibernext.repositories.RolRepository;
import pe.edu.cibernext.services.ProfesorService;
import pe.edu.cibernext.util.CodeGeneratorRandom;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;
    private final RolRepository rolRepository;
    private final CursoRepository cursoRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailSenderService emailSenderService;

    @Value("${spring.application.name}")
    private String nombreApp;

    @Override
    public ProfesorDto buscarPorId(Long id) {
        ProfesorEntity profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Profesor no encontrado con ID: " + id));
        return ProfesorMapper.toDto(profesor);
    }

    @Override
    public boolean verificarExistenciaPorId(Long id) {
        return profesorRepository.existsById(id);
    }

    @Override
    public List<ProfesorDto> listarTodos() {
        return profesorRepository.findAll()
                .stream()
                .map(ProfesorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProfesorDto registrar(ProfesorDto dto) {
        RolEntity rol = rolRepository.findById(dto.getRolId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Rol no encontrado con ID: " + dto.getRolId()));

        if (!"PROFESOR".equalsIgnoreCase(rol.getNombre())) {
            throw new IllegalArgumentException("El rol asignado no es válido para un Profesor.");
        }

        ProfesorEntity profesor = ProfesorMapper.toEntity(dto);

        String passwordInicial = UUID.randomUUID().toString().substring(0, 6);
        String passwordEncriptada = passwordEncoder.encode(passwordInicial);
        profesor.setPassword(passwordEncriptada);

        long totalProfesores = profesorRepository.count();
        String codigoProfesor = CodeGeneratorRandom.generarCodigoUnico("P", totalProfesores);
        String correoProfesional = codigoProfesor.toLowerCase() + "@cibernext.edu.pe";

        profesor.setCodigoProfesor(codigoProfesor);
        profesor.setCorreoProfesional(correoProfesional);

        profesor.setRoles(new HashSet<>(List.of(rol)));

        ProfesorEntity guardado = profesorRepository.save(profesor);

        emailSenderService.enviarEmail(
                guardado.getEmail(),
                "Tu cuenta en " + nombreApp + " ha sido creada correctamente. Aquí tienes tu contraseña inicial para acceder a la plataforma.",
                guardado.getNombre(),
                passwordInicial
        );

        return ProfesorMapper.toDto(guardado);
    }


    @Override
    public ProfesorDto actualizar(Long id, ProfesorDto dto) {
        ProfesorEntity profesor = profesorRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Profesor no encontrado con ID: " + id));

        profesor.setNombre(dto.getNombre());
        profesor.setApellido(dto.getApellido());
        profesor.setDni(dto.getDni());
        profesor.setTelefono(dto.getTelefono());
        profesor.setEmail(dto.getEmail());
        profesor.setCodigoProfesor(dto.getCodigoProfesor());
        profesor.setCorreoProfesional(dto.getCorreoProfesional());
        profesor.setBiografia(dto.getBiografia());
        profesor.setFotoPerfil(dto.getFotoPerfil());

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            profesor.setPassword(passwordEncoder.encode(dto.getPassword())); // ✅ cifrada si viene manual
        }

        if (dto.getRolId() != null) {
            RolEntity rol = rolRepository.findById(dto.getRolId())
                    .orElseThrow(() -> new RecursoNoEncontradoException("Rol no encontrado con ID: " + dto.getRolId()));
            profesor.setRoles(new HashSet<>(List.of(rol)));
        }

        ProfesorEntity actualizado = profesorRepository.save(profesor);
        return ProfesorMapper.toDto(actualizado);
    }

    @Override
    public void eliminarPorId(Long id) {
        if (!profesorRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Profesor no encontrado con ID: " + id);
        }
        profesorRepository.deleteById(id);
    }

    @Override
    public List<CursoDto> listarCursos(Long idProfesor) {
        if (!profesorRepository.existsById(idProfesor)) {
            throw new RecursoNoEncontradoException("Profesor no encontrado con ID: " + idProfesor);
        }
        List<CursoEntity> cursos = cursoRepository.findByProfesores_Id(idProfesor);
        return CursoMapper.toDtoList(cursos);
    }

    @Override
    public List<ProfesorDto> buscarPorFiltro(String filtro) {
        List<ProfesorEntity> profesores = profesorRepository.buscarPorFiltro(filtro);
        return profesores.stream()
                .map(ProfesorMapper::toDto)
                .toList();
    }

}
