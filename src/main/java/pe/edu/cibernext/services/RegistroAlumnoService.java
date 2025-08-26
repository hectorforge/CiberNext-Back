package pe.edu.cibernext.services;

import pe.edu.cibernext.models.dto.RegistroAlumnoRequestDto;
import pe.edu.cibernext.models.dto.RegistroAlumnoResponseDto;

import java.util.List;

public interface RegistroAlumnoService {
    RegistroAlumnoResponseDto registrar(RegistroAlumnoRequestDto request);
    List<RegistroAlumnoResponseDto> listar();
    RegistroAlumnoResponseDto obtenerPorId(Long id);
    void eliminar(Long id);

    List<RegistroAlumnoResponseDto> buscarPorFiltro(String filtro);

}
