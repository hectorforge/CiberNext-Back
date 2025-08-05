package pe.edu.cibernext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibernext.models.RegistroAlumnoEntity;

import java.util.List;
import java.util.Optional;

public interface RegistroAlumnoRepository extends JpaRepository<RegistroAlumnoEntity,Long> {
    Optional<RegistroAlumnoEntity> findByCursoIdAndAlumno_Id(Long cursoId, Long alumnoId);

}
