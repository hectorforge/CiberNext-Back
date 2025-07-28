package pe.edu.cibernext.services;

import pe.edu.cibernext.models.AvanceResponse;
import pe.edu.cibernext.models.dto.UnidadVistaDto;

public interface CursoAvanceService {
    AvanceResponse calcularAvance(Long cursoId, Long alumnoId);
    void registrarUnidadVista(UnidadVistaDto request);
}
