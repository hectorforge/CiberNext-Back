package pe.edu.cibernext.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.mapper.AlumnoMapper;
import pe.edu.cibernext.exceptions.RecursoNoEncontradoException;
import pe.edu.cibernext.models.AlumnoEntity;
import pe.edu.cibernext.models.dto.AlumnoDto;
import pe.edu.cibernext.repositories.AlumnoRepository;
import pe.edu.cibernext.repositories.RolRepository;
import pe.edu.cibernext.services.AlumnoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final RolRepository rolRepository;

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
    public void eliminarPorId(Long id) {
        alumnoRepository.deleteById(id);
    }

}
