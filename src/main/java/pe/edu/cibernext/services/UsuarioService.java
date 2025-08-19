package pe.edu.cibernext.services;

import pe.edu.cibernext.models.dto.UsuarioDto;
import pe.edu.cibernext.models.dto.UsuarioRegistroDto;

import java.util.List;

public interface UsuarioService {

    UsuarioDto buscarPorId(Long id);
    void verificarExistenciaPorId(Long id);
    List<UsuarioDto> listarTodos();
    UsuarioDto registrar(UsuarioRegistroDto dto);
    UsuarioDto actualizar(UsuarioDto dto);
    void eliminarPorId(Long id);
    List<UsuarioDto> buscarPorFiltro(String filtro);
}
