package pe.edu.cibernext.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.mapper.AlumnoMapper;
import pe.edu.cibernext.exceptions.RecursoNoEncontradoException;
import pe.edu.cibernext.models.dto.AlumnoSimpleDto;
import pe.edu.cibernext.models.dto.CursoDto;
import pe.edu.cibernext.repositories.AlumnoRepository;
import pe.edu.cibernext.services.AlumnoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    @Override
    public boolean verificarExistenciaPorId(Long id) {
        return alumnoRepository.existsById(id);
    }

    @Override
    public List<AlumnoSimpleDto> listarTodosPlano() {
        return alumnoRepository.findAll()
                .stream()
                .map(AlumnoMapper::toSimpleDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarPorId(Long id) {
        alumnoRepository.deleteById(id);
    }

    @Override
    public AlumnoSimpleDto buscarPlanoPorId(Long id) {
        var alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Alumno no encontrado con ID: " + id));
        return AlumnoMapper.toSimpleDto(alumno);
    }

    @Override
    public AlumnoSimpleDto actualizarPlano(Long id, AlumnoSimpleDto dto) {
        var alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Alumno no encontrado con ID: " + id));
        AlumnoMapper.updateEntityFromSimpleDto(dto, alumno);
        var guardado = alumnoRepository.save(alumno);
        return AlumnoMapper.toSimpleDto(guardado);
    }

    @Override
    public List<CursoDto> listarCursosPorAlumno(Long idAlumno) {
        if (!alumnoRepository.existsById(idAlumno)) {
            throw new RecursoNoEncontradoException("Alumno no encontrado con ID: " + idAlumno);
        }
        var cursos = alumnoRepository.listarCursosPorAlumno(idAlumno);
        return AlumnoMapper.toCursosDto(cursos);
    }


}
