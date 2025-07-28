package pe.edu.cibernext.services.impl;

import pe.edu.cibernext.Mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.models.RolEntity;
import pe.edu.cibernext.models.UsuarioEntity;
import pe.edu.cibernext.models.dto.UsuarioDto;
import pe.edu.cibernext.repositories.RolRepository;
import pe.edu.cibernext.repositories.UsuarioRepository;
import pe.edu.cibernext.services.UsuarioService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GestionUsuarioServiceImpl  implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final RolRepository rolRepository;

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
    public UsuarioDto registrar(UsuarioDto dto) {
        if (dto.getRol() == null || dto.getRol().getId() == null) {
            throw new IllegalArgumentException("El rol es obligatorio");
        }

        RolEntity rol = rolRepository.findById(dto.getRol().getId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        UsuarioEntity entity = new UsuarioEntity();
        entity.setNombre(dto.getNombre());
        entity.setDni(dto.getDni());
        entity.setCorreo(dto.getCorreo());
        entity.setPassword("123"); // temporal
        entity.setRol(rol); // seteo directo

        return UsuarioMapper.toDto(usuarioRepository.save(entity));
    }

    @Override
    public UsuarioDto actualizar(UsuarioDto dto) {
        UsuarioEntity entity = usuarioRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        entity.setNombre(dto.getNombre());
        entity.setCorreo(dto.getCorreo());
        entity.setDni(dto.getDni());

        if (dto.getRol() != null && dto.getRol().getId() != null) {
            RolEntity rol = rolRepository.findById(dto.getRol().getId())
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
            entity.setRol(rol);
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
