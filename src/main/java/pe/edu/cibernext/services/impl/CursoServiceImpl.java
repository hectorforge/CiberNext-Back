package pe.edu.cibernext.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibernext.mapper.CursoMapper;
import pe.edu.cibernext.models.AlumnoEntity;
import pe.edu.cibernext.models.CursoEntity;
import pe.edu.cibernext.models.RegistroAlumnoEntity;
import pe.edu.cibernext.models.dto.AlumnoCursoDto;
import pe.edu.cibernext.models.dto.CursoDto;
import pe.edu.cibernext.models.dto.ProfesorCursoDto;
import pe.edu.cibernext.models.dto.UnidadAprendizajePorCursoDto;
import pe.edu.cibernext.repositories.CursoRepository;
import pe.edu.cibernext.services.CursoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    @Override
    public CursoDto buscarPorId(Long id) {
        CursoEntity curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
        return CursoMapper.toDto(curso);
    }

    @Override
    public List<CursoDto> listarTodos() {
        return CursoMapper.toDtoList(cursoRepository.findAll());
    }

    @Override
    public CursoDto registrar(CursoDto dto) {
        if (cursoRepository.existsByCodigo(dto.getCodigo())) {
            throw new RuntimeException("El código ya está registrado");
        }
        CursoEntity nuevo = CursoMapper.toEntity(dto);
        return CursoMapper.toDto(cursoRepository.save(nuevo));
    }

    @Override
    public CursoDto actualizar(CursoDto dto) {
        CursoEntity curso = cursoRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        curso.setCodigo(dto.getCodigo());
        curso.setNombre(dto.getNombre());
        curso.setDescripcion(dto.getDescripcion());
        return CursoMapper.toDto(cursoRepository.save(curso));
    }

    @Override
    public void eliminarPorId(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public List<AlumnoCursoDto> listarAlumnosPorCurso(Long idCurso) {
        CursoEntity curso = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + idCurso));

        // Sacar lista de AlumnoEntity desde los registros
        List<AlumnoEntity> alumnos = curso.getRegistrosAlumnos().stream()
                .map(RegistroAlumnoEntity::getAlumno)
                .toList();

        return CursoMapper.toAlumnoCursoList(alumnos);
    }

    @Override
    public List<ProfesorCursoDto> listarProfesoresPorCurso(Long idCurso) {
        if (!cursoRepository.existsById(idCurso)) {
            throw new RuntimeException("Curso no encontrado con ID: " + idCurso);
        }
        return cursoRepository.listarProfesoresPorCurso(idCurso);
    }


    @Override
    public List<UnidadAprendizajePorCursoDto> listarUnidadesArbolPorCurso(Long idCurso) {
        if (!cursoRepository.existsById(idCurso)) {
            throw new RuntimeException("Curso no encontrado con ID: " + idCurso);
        }
        // Trae todas las unidades del curso (con su padre) y construye el árbol vía mapper
        var unidades = cursoRepository.listarUnidadesPorCurso(idCurso);
        return CursoMapper.toUnidadesArbolPorCurso(unidades);
    }

}
