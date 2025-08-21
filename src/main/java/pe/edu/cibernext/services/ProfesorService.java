package pe.edu.cibernext.services;

import pe.edu.cibernext.models.dto.CursoDto;
import pe.edu.cibernext.models.dto.ProfesorDto;

import java.util.List;

public interface ProfesorService {
    ProfesorDto buscarPorId(Long id);
    boolean verificarExistenciaPorId(Long id);
    List<ProfesorDto> listarTodos();
    ProfesorDto registrar(ProfesorDto dto);
    ProfesorDto actualizar(Long id, ProfesorDto profesorDto);
    void eliminarPorId(Long id);

    List<CursoDto> listarCursos(Long idProfesor);
}
