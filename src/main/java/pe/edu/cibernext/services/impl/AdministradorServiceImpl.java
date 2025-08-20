package pe.edu.cibernext.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.mapper.AdministradorMapper;
import pe.edu.cibernext.models.AdministradorEntity;
import pe.edu.cibernext.models.RolEntity;
import pe.edu.cibernext.models.dto.AdministradorDto;
import pe.edu.cibernext.repositories.AdministradorRepository;
import pe.edu.cibernext.repositories.RolRepository;
import pe.edu.cibernext.services.AdministradorService;
import pe.edu.cibernext.util.CodeGeneratorRandom;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdministradorServiceImpl implements AdministradorService {

    private final AdministradorRepository repository;
    private final AdministradorMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final EmailSenderService emailSenderService;
    private final RolRepository rolRepository;

    @Value("${spring.application.name}")
    private String nombreApp;

    @Override
    public AdministradorDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(entity -> mapper.toDto(entity, false))
                .orElseThrow(() -> new RuntimeException("Administrador no encontrado con ID " + id));
    }

    @Override
    public void verificarExistenciaPorId(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Administrador no existe con ID " + id);
        }
    }

    @Override
    public List<AdministradorDto> listarTodos() {
        return repository.findAll()
                .stream()
                .map(entity -> mapper.toDto(entity, false))
                .collect(Collectors.toList());
    }

    @Override
    public AdministradorDto registrar(AdministradorDto dto) {
        AdministradorEntity entity = mapper.toEntity(dto);

        // Verificar el ROL y setearle al administrador
        RolEntity rol = rolRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        entity.setRoles(Set.of(rol));

        // Cifrado de contraseña
        String passwordGenerateInitial = UUID.randomUUID().toString().substring(0, 8);
        String passswordEncoded = passwordEncoder.encode(passwordGenerateInitial);// Encriptar la contraseña
        entity.setPassword(passswordEncoded);
        AdministradorEntity administradorSaved = repository.save(entity);
        emailSenderService.enviarEmail(
                administradorSaved.getEmail(),
                "Tu cuenta en " + nombreApp + " ha sido creada correctamente. Aquí tienes tu contraseña inicial para acceder a la plataforma.",
                administradorSaved.getNombre(),
                passwordGenerateInitial
        );

        return mapper.toDto(administradorSaved, false);
    }

    @Override
    public AdministradorDto actualizar(AdministradorDto dto) {
        AdministradorEntity entity = repository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Administrador no encontrado con ID " + dto.getId()));
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setDni(dto.getDni());
        entity.setEmail(dto.getEmail());
        entity.setTelefono(dto.getTelefono());
        entity.setFotoPerfil(dto.getFotoPerfil());
        entity.setPassword(dto.getPassword());
        AdministradorEntity updated = repository.save(entity);
        return mapper.toDto(updated, false);
    }

    @Override
    public void eliminarPorId(Long id) {
        verificarExistenciaPorId(id);
        repository.deleteById(id);
    }

    @Override
    public List<AdministradorDto> buscarPorFiltro(String filtro) {
        return repository.buscarPorFiltro(filtro)
                .stream()
                .map(entity -> mapper.toDto(entity, false))
                .collect(Collectors.toList());
    }
}