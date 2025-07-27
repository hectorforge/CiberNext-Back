package pe.edu.cibernext.services.impl;

import pe.edu.cibernext.Mapper.RolMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.models.RolEntity;
import pe.edu.cibernext.models.dto.RolConUsuariosDto;
import pe.edu.cibernext.models.dto.RolDto;
import pe.edu.cibernext.repositories.RolRepository;
import pe.edu.cibernext.services.RolService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    @Override
    public RolConUsuariosDto buscarPorId(Long id) {
        RolEntity entity = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + id));
        return RolMapper.toConUsuariosDto(entity);
    }

    @Override
    public List<RolDto> listarTodos() {
        return RolMapper.toDtoList(rolRepository.findAll());
    }

    @Override
    public RolDto registrar(RolDto dto) {
        RolEntity entity = RolMapper.toEntity(dto);
        return RolMapper.toDto(rolRepository.save(entity));
    }

    @Override
    public RolDto actualizar(RolDto dto) {
        RolEntity entity = rolRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        entity.setNombre(dto.getNombre());
        return RolMapper.toDto(rolRepository.save(entity));
    }

    @Override
    public void eliminarPorId(Long id) {
        rolRepository.deleteById(id);
    }

    @Override
    public List<RolConUsuariosDto> listarRolesConUsuarios() {
        List<RolEntity> roles = rolRepository.findAll();
        return RolMapper.toConUsuariosDtoList(roles);
    }

}
