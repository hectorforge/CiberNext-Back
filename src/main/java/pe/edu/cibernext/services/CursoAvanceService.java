package pe.edu.cibernext.services;

import pe.edu.cibernext.models.dto.CursoAlumnoAvanceDto;
import pe.edu.cibernext.models.dto.UnidadVistaDto;

public interface CursoAvanceService {
    CursoAlumnoAvanceDto calcularAvance(Long cursoId, Long alumnoId);
    void registrarUnidadVista(UnidadVistaDto request);
}
