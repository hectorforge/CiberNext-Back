package pe.edu.cibernext.services;

import pe.edu.cibernext.models.dto.CurriculaDto;
import pe.edu.cibernext.models.dto.CurriculaRespuestaDto;

import java.util.List;

public interface CurriculaService {
    CurriculaRespuestaDto buscarPorId(Long id);
    List<CurriculaRespuestaDto> listarTodos();
    List<CurriculaRespuestaDto> listarPorCurso(Long cursoId);
    CurriculaDto registrar(CurriculaDto dto);
    CurriculaDto actualizar(CurriculaDto dto);
    void eliminar(Long id);
}