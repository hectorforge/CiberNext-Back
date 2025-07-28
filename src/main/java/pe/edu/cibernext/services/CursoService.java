package pe.edu.cibernext.services;

import pe.edu.cibernext.models.dto.CursoDto;

import java.util.List;

public interface CursoService {

    CursoDto buscarPorId(Long id);
    List<CursoDto> listarTodos();
    CursoDto registrar(CursoDto dto);
    CursoDto actualizar(CursoDto dto);
    void eliminarPorId(Long id);
}
