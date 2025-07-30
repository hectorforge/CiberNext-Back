package pe.edu.cibernext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibernext.models.UnidadAprendizajeEntity;

import java.util.List;

public interface UnidadAprendizajeRepository extends JpaRepository<UnidadAprendizajeEntity,Long> {

    long countByCursoId(Long cursoId);

    List<UnidadAprendizajeEntity> findByCursoId(Long cursoId);

    List<UnidadAprendizajeEntity> findAllByPadreIsNullOrderById();

}
