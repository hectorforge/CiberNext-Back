package pe.edu.cibernext.services;

import pe.edu.cibernext.models.dto.ProfesorDto;
import pe.edu.cibernext.models.dto.ProfesorRegistroDto;

import java.util.List;

public interface ProfesorService {
    ProfesorDto buscarPorId(Long id);
    boolean verificarExistenciaPorId(Long id);
    List<ProfesorDto> listarTodos();
    ProfesorDto registrar(ProfesorRegistroDto profesorRegistroDto);
    void eliminarPorId(Long id);
}
