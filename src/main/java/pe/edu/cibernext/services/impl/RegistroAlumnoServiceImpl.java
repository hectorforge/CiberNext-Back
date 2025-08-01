package pe.edu.cibernext.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.mapper.RegistroAlumnoMapper;
import pe.edu.cibernext.models.RegistroAlumnoEntity;
import pe.edu.cibernext.models.dto.RegistroAlumnoRequestDto;
import pe.edu.cibernext.models.dto.RegistroAlumnoResponseDto;
import pe.edu.cibernext.repositories.AlumnoRepository;
import pe.edu.cibernext.repositories.CursoRepository;
import pe.edu.cibernext.repositories.ProfesorRepository;
import pe.edu.cibernext.repositories.RegistroAlumnoRepository;
import pe.edu.cibernext.services.RegistroAlumnoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistroAlumnoServiceImpl implements RegistroAlumnoService {

    private final RegistroAlumnoRepository registroRepo;
    private final CursoRepository cursoRepo;
    private final AlumnoRepository alumnoRepo;
    private final ProfesorRepository profesorRepo;

    @Override
    public RegistroAlumnoResponseDto registrar(RegistroAlumnoRequestDto request) {
        RegistroAlumnoEntity entity = new RegistroAlumnoEntity();

        entity.setCurso(cursoRepo.findById(request.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado")));

        entity.setAlumno(alumnoRepo.findById(request.getAlumnoId())
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado")));

        entity.setProfesor(profesorRepo.findById(request.getProfesorId())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado")));

        RegistroAlumnoEntity saved = registroRepo.save(entity);
        return RegistroAlumnoMapper.toDto(saved);
    }

    @Override
    public List<RegistroAlumnoResponseDto> listar() {
        return registroRepo.findAll().stream()
                .map(RegistroAlumnoMapper::toDto)
                .toList();
    }

    @Override
    public RegistroAlumnoResponseDto obtenerPorId(Long id) {
        return registroRepo.findById(id)
                .map(RegistroAlumnoMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
    }

    @Override
    public void eliminar(Long id) {
        registroRepo.deleteById(id);
    }
}