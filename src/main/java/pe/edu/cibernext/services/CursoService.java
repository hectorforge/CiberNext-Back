package pe.edu.cibernext.services;

import pe.edu.cibernext.models.CursoEntity;
import pe.edu.cibernext.models.dto.AlumnoCursoDto;
import pe.edu.cibernext.models.dto.CursoDto;
import pe.edu.cibernext.models.dto.ProfesorCursoDto;
import pe.edu.cibernext.models.dto.UnidadAprendizajePorCursoDto;

import java.util.List;

public interface CursoService {

    CursoDto buscarPorId(Long id);
    List<CursoDto> listarTodos();
    CursoDto registrar(CursoDto dto);
    CursoDto actualizar(CursoDto dto);
    void eliminarPorId(Long id);
    List<AlumnoCursoDto> listarAlumnosPorCurso(Long idCurso);
    List<ProfesorCursoDto> listarProfesoresPorCurso(Long idCurso);
    List<UnidadAprendizajePorCursoDto> listarUnidadesArbolPorCurso(Long idCurso);
    List<CursoDto> buscarPorFiltro(String filtro);
}
