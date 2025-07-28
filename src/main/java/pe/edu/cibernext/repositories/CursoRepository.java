package pe.edu.cibernext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibernext.models.CursoEntity;

public interface CursoRepository extends JpaRepository<CursoEntity,Long> {
    boolean existsByCodigo(String codigo);
}
