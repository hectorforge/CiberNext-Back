package pe.edu.cibernext.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.mapper.RolMapper;
import pe.edu.cibernext.models.dto.RolDto;
import pe.edu.cibernext.repositories.RolRepository;
import pe.edu.cibernext.services.RolService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    @Override
    public List<RolDto> listarRoles() {
        return rolRepository.findAll()
                .stream()
                .map(rolMapper::toDto)
                .collect(Collectors.toList());
    }
}
