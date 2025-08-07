package pe.edu.cibernext.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.exceptions.RecursoNoEncontradoException;
import pe.edu.cibernext.mapper.ProfesorMapper;
import pe.edu.cibernext.models.ProfesorEntity;
import pe.edu.cibernext.models.dto.ProfesorDto;
import pe.edu.cibernext.models.dto.ProfesorRegistroDto;
import pe.edu.cibernext.repositories.ProfesorRepository;
import pe.edu.cibernext.repositories.RolRepository;
import pe.edu.cibernext.services.ProfesorService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;
    private final RolRepository rolRepository;

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
    public ProfesorDto registrar(ProfesorRegistroDto profesorRegistroDto) {

        var rol = rolRepository.findById(profesorRegistroDto.getRolId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Rol no encontrado con ID: " + profesorRegistroDto.getRolId()));

        ProfesorEntity profesor = new ProfesorEntity();
        profesor.setNombre(profesorRegistroDto.getNombre());
        profesor.setDni(profesorRegistroDto.getDni());
        profesor.setEmail(profesorRegistroDto.getCorreo());

        // Por ahora, guardar contraseña tal cual (sin encriptar)
        profesor.setPassword(profesorRegistroDto.getPassword());

        profesor.setRoles(rol);
        profesor.setCodigoProfesor(profesorRegistroDto.getCodigoProfesor());
        profesor.setCorreoProfesional(profesorRegistroDto.getCorreoProfesional());
        profesor.setBiografia(profesorRegistroDto.getBiografia());
        profesor.setFotoPerfil(profesorRegistroDto.getFotoPerfil());

        ProfesorEntity profesorGuardado = profesorRepository.save(profesor);
        return ProfesorMapper.toDto(profesorGuardado);
    }

    @Override
    public void eliminarPorId(Long id) {
        profesorRepository.deleteById(id);
    }
}

