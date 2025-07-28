package pe.edu.cibernext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibernext.models.UnidadVista;

public interface UnidadVistaRepository extends JpaRepository<UnidadVista, Long> {

    int countByRegistroAlumnoId(Long registroAlumnoId);

    boolean existsByUnidadAprendizajeIdAndRegistroAlumnoId(Long unidadId, Long registroAlumnoId);
}
