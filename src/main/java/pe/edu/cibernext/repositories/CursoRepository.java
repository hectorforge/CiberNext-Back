package pe.edu.cibernext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibernext.models.CursoEntity;

import java.util.List;

public interface CursoRepository extends JpaRepository<CursoEntity,Long> {
    boolean existsByCodigo(String codigo);

    List<CursoEntity> findByProfesores_Id(Long profesorId);
}
