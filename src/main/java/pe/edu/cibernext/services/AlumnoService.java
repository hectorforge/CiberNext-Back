package pe.edu.cibernext.services;

import pe.edu.cibernext.models.dto.AlumnoDto;
import pe.edu.cibernext.models.dto.CursoDto;

import java.util.List;

public interface AlumnoService {
    AlumnoDto buscarPorId(Long id);
    boolean verificarExistenciaPorId(Long id);
    List<AlumnoDto> listarTodos();
    AlumnoDto registrar(AlumnoDto dto);
    AlumnoDto actualizar(Long id, AlumnoDto dto);
    void eliminarPorId(Long id);
    List<CursoDto> listarCursos(Long idAlumno);
}
