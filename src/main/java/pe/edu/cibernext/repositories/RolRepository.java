package pe.edu.cibernext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibernext.models.RolEntity;

public interface RolRepository extends JpaRepository<RolEntity, Long> {
}
