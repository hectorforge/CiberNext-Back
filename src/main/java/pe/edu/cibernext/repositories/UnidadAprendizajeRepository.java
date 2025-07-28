package pe.edu.cibernext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibernext.models.UnidadAprendizajeEntity;

public interface UnidadAprendizajeRepository extends JpaRepository<UnidadAprendizajeEntity,Long> {

    long countByCursoId(Long cursoId);

}
