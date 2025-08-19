package pe.edu.cibernext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibernext.models.CurriculaEntity;

import java.util.List;

public interface CurriculaRepository extends JpaRepository<CurriculaEntity, Long> {
    List<CurriculaEntity> findByCursoId(Long cursoId);
    List<CurriculaEntity> findByAreaEspecializacionId(Long areaEspecializacionId);
}
