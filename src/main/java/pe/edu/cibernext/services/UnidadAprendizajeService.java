package pe.edu.cibernext.services;

import pe.edu.cibernext.models.dto.UnidadAprendizajeDto;
import pe.edu.cibernext.models.dto.UnidadAprendizajeRespuestaDto;

import java.util.List;

public interface UnidadAprendizajeService {
    UnidadAprendizajeRespuestaDto buscarPorId(Long id);
    List<UnidadAprendizajeRespuestaDto> listarTodos();
    List<UnidadAprendizajeRespuestaDto> listarPorCurso(Long cursoId);

    UnidadAprendizajeDto registrar(UnidadAprendizajeDto dto);
    UnidadAprendizajeDto actualizar(UnidadAprendizajeDto dto);
    void eliminarPorId(Long id);
}
