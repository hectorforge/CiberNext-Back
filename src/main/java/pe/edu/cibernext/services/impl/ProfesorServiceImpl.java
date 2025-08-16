package pe.edu.cibernext.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.exceptions.RecursoNoEncontradoException;
import pe.edu.cibernext.mapper.ConsultaMapper;
import pe.edu.cibernext.mapper.CursoMapper;
import pe.edu.cibernext.mapper.ProfesorMapper;
import pe.edu.cibernext.models.CursoEntity;
import pe.edu.cibernext.models.ProfesorEntity;
import pe.edu.cibernext.models.dto.CursoDto;
import pe.edu.cibernext.models.dto.ProfesorDto;
import pe.edu.cibernext.models.dto.ProfesorRegistroDto;
import pe.edu.cibernext.repositories.CursoRepository;
import pe.edu.cibernext.repositories.ProfesorRepository;
import pe.edu.cibernext.repositories.RolRepository;
import pe.edu.cibernext.services.ProfesorService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;
    private final RolRepository rolRepository;
    private final CursoRepository cursoRepository;

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

        profesor.setRoles(Set.of(rol));
        profesor.setCodigoProfesor(profesorRegistroDto.getCodigoProfesor());
        profesor.setCorreoProfesional(profesorRegistroDto.getCorreoProfesional());
        profesor.setBiografia(profesorRegistroDto.getBiografia());
        profesor.setFotoPerfil(profesorRegistroDto.getFotoPerfil());

        ProfesorEntity profesorGuardado = profesorRepository.save(profesor);
        return ProfesorMapper.toDto(profesorGuardado);
    }

    @Override
    public ProfesorDto actualizar(Long id, ProfesorDto profesorDto) {
        ProfesorEntity profesor = ProfesorMapper.toEntity(profesorDto);
        profesor.setId(id);
        ProfesorEntity profesorGuardado = profesorRepository.save(profesor);
        return ProfesorMapper.toDto(profesorGuardado);
    }

    @Override
    public void eliminarPorId(Long id) {
        try {
            profesorRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new RecursoNoEncontradoException("Profesor no encontrado con ID: " + id);
        }
    }
    @Override
    public List<CursoDto> listarCursos(Long idProfesor) {
        if (!profesorRepository.existsById(idProfesor)) {
            throw new RecursoNoEncontradoException("Profesor no encontrado con ID: " + idProfesor);
        }
        List<CursoEntity> cursos = cursoRepository.findByProfesores_Id(idProfesor);
        return CursoMapper.toDtoList(cursos);
    }
}

