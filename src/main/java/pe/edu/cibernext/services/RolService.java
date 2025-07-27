package pe.edu.cibernext.services;

import pe.edu.cibernext.models.dto.RolConUsuariosDto;
import pe.edu.cibernext.models.dto.RolDto;

import java.util.List;

public interface RolService {
    RolConUsuariosDto buscarPorId(Long id);
    List<RolDto> listarTodos();
    RolDto registrar(RolDto dto);
    RolDto actualizar(RolDto dto);
    void eliminarPorId(Long id);

    // Listado especial
    List<RolConUsuariosDto> listarRolesConUsuarios();

}
