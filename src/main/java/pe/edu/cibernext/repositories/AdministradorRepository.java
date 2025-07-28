package pe.edu.cibernext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibernext.models.AdministradorEntity;

public interface AdministradorRepository extends JpaRepository<AdministradorEntity,Long> {
}
