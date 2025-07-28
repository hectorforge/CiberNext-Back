package pe.edu.cibernext.services;

import pe.edu.cibernext.models.dto.AlumnoDto;
import pe.edu.cibernext.models.dto.AlumnoRegistroDto;
import pe.edu.cibernext.models.dto.UsuarioDto;

import java.util.List;

public interface AlumnoService {


    AlumnoDto buscarPorId(Long id);
    boolean verificarExistenciaPorId(Long id);
    List<AlumnoDto> listarTodos();
    void eliminarPorId(Long id);

}
