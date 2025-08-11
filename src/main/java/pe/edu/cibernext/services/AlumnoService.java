package pe.edu.cibernext.services;

import pe.edu.cibernext.models.dto.AlumnoSimpleDto;
import pe.edu.cibernext.models.dto.CursoDto;

import java.util.List;

public interface AlumnoService {

    boolean verificarExistenciaPorId(Long id);
    void eliminarPorId(Long id);
    List<AlumnoSimpleDto> listarTodosPlano();
    AlumnoSimpleDto buscarPlanoPorId(Long id);
    AlumnoSimpleDto actualizarPlano(Long id, AlumnoSimpleDto dto);

    List<CursoDto> listarCursosPorAlumno(Long idAlumno);

}
