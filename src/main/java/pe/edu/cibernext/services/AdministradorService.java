package pe.edu.cibernext.services;

import pe.edu.cibernext.models.dto.AdministradorDto;

import java.util.List;

public interface AdministradorService {
    AdministradorDto buscarPorId(Long id);
    void verificarExistenciaPorId(Long id);
    List<AdministradorDto> listarTodos();
    AdministradorDto registrar(AdministradorDto dto);
    AdministradorDto actualizar(AdministradorDto dto);
    void eliminarPorId(Long id);
    List<AdministradorDto> buscarPorFiltro(String filtro);
}
