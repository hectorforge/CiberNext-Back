package pe.edu.cibernext.services.impl;

import pe.edu.cibernext.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.models.*;
import pe.edu.cibernext.models.dto.UsuarioDto;
import pe.edu.cibernext.models.dto.UsuarioRegistroDto;
import pe.edu.cibernext.repositories.*;
import pe.edu.cibernext.services.UsuarioService;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GestionUsuarioServiceImpl  implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final RolRepository rolRepository;
    private final AlumnoRepository alumnoRepository;
    private final ProfesorRepository profesorRepository;
    private final AdministradorRepository administradorRepository;

    @Override
    public UsuarioDto buscarPorId(Long id) {
        UsuarioEntity entity = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
        return UsuarioMapper.toDto(entity);
    }

    @Override
    public void verificarExistenciaPorId(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("No existe el usuario con ID: " + id);
        }
    }

    @Override
    public List<UsuarioDto> listarTodos() {
        return UsuarioMapper.toDtoList(usuarioRepository.findAll());
    }

    @Override
    public UsuarioDto registrar(UsuarioRegistroDto dto) {
        RolEntity rol = rolRepository.findById(dto.getRolId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        UsuarioEntity usuario = UsuarioMapper.toEntity(dto, rol);
        UsuarioEntity guardado = usuarioRepository.save(usuario);

        return UsuarioMapper.toDto(guardado);
    }


    @Override
    public UsuarioDto actualizar(UsuarioDto dto) {
        UsuarioEntity entity = usuarioRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        entity.setNombre(dto.getNombre());
        entity.setEmail(dto.getCorreo());
        entity.setDni(dto.getDni());

        if (dto.getRol() != null && dto.getRol().getId() != null) {
            RolEntity rol = rolRepository.findById(dto.getRol().getId())
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
            entity.setRoles(Set.of(rol));
        }

        return UsuarioMapper.toDto(usuarioRepository.save(entity));
    }


    @Override
    public void eliminarPorId(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<UsuarioDto> buscarPorFiltro(String filtro) {
        return UsuarioMapper.toDtoList(usuarioRepository.buscarPorFiltro(filtro));
    }

}
